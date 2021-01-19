package com.buckriderstudio.com;

import com.badlogic.gdx.Game;
import com.buckriderstudio.com.util.Assets;

public class DefenseGame extends Game
{
	
	@Override
	public void create () {
		Assets assets = new Assets();
		assets.load();
		assets.getAssetManager().finishLoading();

		setScreen(new EditorScreen(assets.getAssetManager()));
	}
}
