package com.com.kilobolt.gameworld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.com.kilobolt.com.kilobolt.assetloader.assetloader;
import com.com.kilobolt.gameobjects.Bird;
import com.com.kilobolt.gameobjects.ScrollHandler;

/**
 * Created by chandanj on 7/11/2015.
 */
public class GameWorld {
    private Bird bird;
    private ScrollHandler scrollHandler;
    private boolean isAlive = true;
    private Rectangle ground;
    private int score = 0;
    private int midPointY;

    public enum GameState{
        READY, RUNNING, GAMEOVER
    }
    private GameState currentState;

    public GameWorld(int midPointY) {
        currentState = GameState.READY;
        bird = new Bird(33, midPointY - 5, 17, 12);
        scrollHandler = new ScrollHandler(this, midPointY+66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
        currentState = GameState.READY;
        this.midPointY= midPointY;
    }

    public void update(float delta) {
        if (currentState == GameState.READY) {
            updateReady(delta);

        } else if (currentState == GameState.RUNNING) {
            updateRunning(delta);

        }
    }

    public void updateRunning(float delta)
    {

        if (delta > .15f) {
            delta = .15f;
        }

        bird.update(delta);
        scrollHandler.update(delta);
        if (bird.isAlive() && scrollHandler.collides(bird)) {
            scrollHandler.stop();
            assetloader.dead.play();
            isAlive = false;
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scrollHandler.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;
        }
    }

    public Bird getBird() {
        return bird;

    }
    public ScrollHandler getScroller() {
        return scrollHandler;
    }
    public int getScore() {
        return score;
    }
    public void addScore(int increment) {
        score += increment;
    }

    public boolean isReady()
    {
        return (currentState==GameState.READY);
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public boolean isGameOver() {
        return (currentState == GameState.GAMEOVER);
    }
    public void restart()
    {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        scrollHandler.onRestart();
        currentState = GameState.READY;
    }

    public void updateReady(float delta)
    {

    }
}
