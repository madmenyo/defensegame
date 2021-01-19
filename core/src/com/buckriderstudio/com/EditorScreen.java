package com.buckriderstudio.com;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.buckriderstudio.com.components.TextureComponent;
import com.buckriderstudio.com.components.TransformComponent;
import com.buckriderstudio.com.level.Direction;
import com.buckriderstudio.com.util.Assets;

/**
 * DefenseGame [2021]
 * By Menno Gouw
 */

public class EditorScreen extends ScreenAdapter
{
	private AssetManager assetManager;
	private Viewport worldView;
	private SpriteBatch worldBatch;

	private PooledEngine engine = new PooledEngine();

	public EditorScreen(AssetManager assetManager)
	{
		this.assetManager = assetManager;

		worldView = new ScreenViewport();
		worldBatch = new SpriteBatch();
	}

	@Override
	public void show()
	{

		// TEST
		engine.addSystem(new RenderSystem(worldView, worldBatch, assetManager.get(Assets.SpriteSheet)));


		for (int i = 0; i < 50; i++)
		{
			Entity e = new Entity();
			TransformComponent transformComponent = new TransformComponent();
			transformComponent.position.set(MathUtils.random() * 1200, MathUtils.random() * 700);
			e.add(transformComponent);

			TextureComponent textureComponent = new TextureComponent();
			textureComponent.regionName = "creep1_red";
			e.add(textureComponent);

			engine.addEntity(e);
		}
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(.06f, .05f, .075f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);




		engine.update(delta);
	}

	@Override
	public void resize(int width, int height)
	{
		worldView.update(width, height, true);
	}
}
