package com.com.kilobolt.inputhandler;

import com.badlogic.gdx.InputProcessor;
import com.com.kilobolt.gameobjects.Bird;
import com.com.kilobolt.gameworld.GameWorld;

/**
 * Created by chandanj on 7/11/2015.
 */
public class inputHandler implements InputProcessor{
    private Bird myBird;
    private GameWorld gameWorld;
    // Ask for a reference to the Bird when InputHandler is created.
    public inputHandler(GameWorld gameWorld) {
        // myBird now represents the gameWorld's bird.
        this.gameWorld = gameWorld;
        myBird= gameWorld.getBird();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(gameWorld.isReady())
        {
            gameWorld.start();
        }
        myBird.onClick();
        if(gameWorld.isGameOver())
        {
            gameWorld.restart();
        }
        return true; // Return true to say we handled the touch.
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
