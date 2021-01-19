package com.buckriderstudio.com.util;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * DefenseGame [2021]
 * By Menno Gouw
 */

public class Assets
{
	private AssetManager assetManager = new AssetManager();

	public AssetManager getAssetManager()
	{
		return assetManager;
	}

	public static final AssetDescriptor<com.badlogic.gdx.scenes.scene2d.ui.Skin> Skin = new AssetDescriptor<>("gui/gui.json",
			Skin.class, new SkinLoader.SkinParameter("gui/gui.atlas"));

	public static final AssetDescriptor<TextureAtlas> SpriteSheet = new AssetDescriptor<>("sprites/spritesheet.atlas", TextureAtlas.class);

	// Sounds
	public static final AssetDescriptor<Sound> Shot_01 = new AssetDescriptor<Sound>("sounds/shot01.wav", Sound.class);


	public void load(){
		assetManager.load(Skin);
		assetManager.load(SpriteSheet);
		assetManager.load(Shot_01);

	}
}