package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.com.kilobolt.com.kilobolt.assetloader.assetloader;
import com.com.kilobolt.gameworld.GameRenderer;
import com.com.kilobolt.gameworld.GameWorld;
import com.kilobolt.screens.GameScreen;

public class ZBGame extends Game{


	@Override
	public void create() {
		System.out.println("ZBGame Created!");
		assetloader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		assetloader.dispose();
	}
}
