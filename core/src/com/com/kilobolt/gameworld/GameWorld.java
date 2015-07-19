package com.com.kilobolt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.com.kilobolt.gameobjects.Bird;
import com.com.kilobolt.gameobjects.ScrollHandler;

/**
 * Created by chandanj on 7/11/2015.
 */
public class GameWorld {
    private Bird bird;
    private ScrollHandler scrollHandler;
    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scrollHandler = new ScrollHandler(midPointY+66);
    }

    public void update(float delta) {
        bird.update(delta);
        scrollHandler.update(delta);
    }

    public Bird getBird() {
        return bird;

    }
    public ScrollHandler getScroller() {
        return scrollHandler;
    }

}
