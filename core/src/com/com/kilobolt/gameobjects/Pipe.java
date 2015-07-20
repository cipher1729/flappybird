package com.com.kilobolt.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by chandanj on 7/17/2015.
 */
public class Pipe extends scrollable {

    private Random r;
    private Rectangle skullUp, skullDown, barUp, barDown;
    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;
    private float groundY;
    private  boolean isScored = false;
    // When Pipe's constructor is invoked, invoke the super (Scrollable)
    // constructor
    public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY) {
        super(x, y, width, height, scrollSpeed);
        // Initialize a Random object for Random number generation
        r = new Random();skullUp = new Rectangle();
        skullDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();
        this.groundY = groundY;
    }

    @Override
    public void reset(float newX) {
        // Call the reset method in the superclass (Scrollable)
        super.reset(newX);
        // Change the height to a random number
        height = r.nextInt(90) + 15;
        isScored = false;
    }

    @Override
    public  void update(float delta)
    {
        super.update(delta);
        float shift = (SKULL_WIDTH- width)/2;
        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y+height+ VERTICAL_GAP,width,groundY-(position.y+VERTICAL_GAP+height));
        skullUp.set(position.x - shift , position.y+height- SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x -shift, barDown.getY(), SKULL_WIDTH, SKULL_HEIGHT);
        
    }
    public Rectangle getSkullUp() {
        return skullUp;
    }

    public Rectangle getSkullDown() {
        return skullDown;
    }

    public Rectangle getBarUp() {
        return barUp;
    }

    public Rectangle getBarDown() {
        return barDown;
    }

    public boolean collides(Bird bird) {
        if (position.x < bird.getX() + bird.getWidth()) {
            return (Intersector.overlaps(bird.getBoundingCircle(), barUp)
                    || Intersector.overlaps(bird.getBoundingCircle(), barDown)
                    || Intersector.overlaps(bird.getBoundingCircle(), skullUp) || Intersector
                    .overlaps(bird.getBoundingCircle(), skullDown));
        }
        return false;
    }

    public boolean isScored() {
        return isScored;
    }
    public void setScored(boolean b) {
        isScored = b;
    }

}
