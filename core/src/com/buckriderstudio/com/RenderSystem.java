package com.buckriderstudio.com;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.buckriderstudio.com.components.TextureComponent;
import com.buckriderstudio.com.components.TransformComponent;
import com.buckriderstudio.com.level.Level;
import com.buckriderstudio.com.util.Mappers;
import com.buckriderstudio.com.util.ZComparator;

import java.util.Comparator;

public class RenderSystem extends SortedIteratingSystem
{
	private static final Family FAMILY = Family.all(TextureComponent.class, TransformComponent.class).get();

	private Array<Entity> renderQueue;
	private Comparator<Entity> comparator;
	private Viewport worldView;
	private SpriteBatch worldBatch;
	private TextureAtlas atlas;

	public RenderSystem(Viewport worldView, SpriteBatch worldBatch, TextureAtlas atlas)
	{
		super(FAMILY, new ZComparator());

		this.worldView = worldView;
		this.worldBatch = worldBatch;
		this.atlas = atlas;

		renderQueue = new Array<>();
	}

	@Override
	public void update(float deltaTime)
	{
		super.update(deltaTime);

		worldView.getCamera().update();
		worldBatch.setProjectionMatrix(worldView.getCamera().combined);

		worldBatch.begin();
		for (Entity entity : renderQueue)
		{
			TransformComponent tc = Mappers.TRANSFORM_COMPONENT.get(entity);

			worldBatch.draw(atlas.findRegion(Mappers.TEXTURE_COMPONENT.get(entity).regionName),
					tc.position.x, tc.position.y, Level.TILE_SIZE * tc.scale.x, Level.TILE_SIZE * tc.scale.y
					);
		}
		worldBatch.end();

		renderQueue.clear();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime)
	{
		renderQueue.add(entity);
	}
}
