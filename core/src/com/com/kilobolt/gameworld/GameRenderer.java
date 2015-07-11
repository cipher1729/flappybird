package com.com.kilobolt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by chandanj on 7/11/2015.
 */

public class GameRenderer {
    GameWorld gameWorld;
    private OrthographicCamera cam;
    ShapeRenderer shapeRenderer;
    public void render() {
        Gdx.app.log("GameRenderer", "render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
        shapeRenderer.rect(gameWorld.getRect().x, gameWorld.getRect().y,
                gameWorld.getRect().width, gameWorld.getRect().height);

        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        // Chooses RGB Color of 255, 109, 120 at full opacity
        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        // Draws the rectangle from myWorld (Using ShapeType.Line)
        shapeRenderer.rect(gameWorld.getRect().x, gameWorld.getRect().y,
                gameWorld.getRect().width, gameWorld.getRect().height);

        shapeRenderer.end();
    }

    public GameRenderer(GameWorld world)
    {
        gameWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true,136,204);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

    }
}
