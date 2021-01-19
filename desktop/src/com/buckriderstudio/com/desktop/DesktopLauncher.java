package com.buckriderstudio.com.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.buckriderstudio.com.DefenseGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		packSprites();
		packSkin();

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.forceExit = false;
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new DefenseGame(), config);
	}

	private static void packSprites()
	{
		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.filterMin = Texture.TextureFilter.Nearest;
		settings.filterMag = Texture.TextureFilter.Nearest;
		settings.combineSubdirectories = true;
		settings.flattenPaths = true;
		settings.fast = true;

		String input = "../../images/sprites";
		String output = "sprites";
		String packName = "spritesheet.atlas";
		TexturePacker.process(settings, input, output, packName);

	}

	private static void packSkin()
	{
		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.filterMin = Texture.TextureFilter.Nearest;
		settings.filterMag = Texture.TextureFilter.Nearest;
		settings.combineSubdirectories = true;
		settings.flattenPaths = true;
		settings.fast = true;

		String input = "../../images/skin";
		String output = "gui";
		String packName = "gui.atlas";
		TexturePacker.process(settings, input, output, packName);
	}
}
