package com.kilobolt.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.com.kilobolt.gameworld.GameRenderer;
import com.com.kilobolt.gameworld.GameWorld;

/**
 * Created by chandanj on 7/11/2015.
 */
public class GameScreen implements Screen {
    GameRenderer gameRenderer;
    GameWorld gameWorld;
    public GameScreen()
    {
        Gdx.app.log("GameScreen", "Attached");
        Gdx.app.log("GameScreen", "Attached");
        gameWorld= new GameWorld();
        gameRenderer =  new GameRenderer(gameWorld);
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(10 / 255.0f, 15 / 255.0f, 230 / 255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Gdx.app.log("GameScreen FPS",1/delta+ "");
        gameWorld.update(delta);
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
