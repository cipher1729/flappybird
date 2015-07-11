package com.com.kilobolt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by chandanj on 7/11/2015.
 */
public class GameWorld {
    private Rectangle rect = new Rectangle(0, 0, 17, 12);
    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
        rect.y++;
        if (rect.y > 204) {
            rect.y = 0;
        }
    }

    public Rectangle getRect() {
        return rect;
    }
}
