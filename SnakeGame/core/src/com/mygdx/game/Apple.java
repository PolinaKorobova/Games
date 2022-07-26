package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Apple {
    Texture texture;
    Vector2 position;
    int appleX;
    int appleY;

    public Apple() {
        texture = new Texture("apples.png");
        position = new Vector2(0, 0);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, appleX, appleY);
    }

    public void update() {
        appleX = new Random().nextInt(25)* texture.getHeight();
        appleY = new Random().nextInt(25)* texture.getHeight();
    }

    public void recreate() {
        position = new Vector2(0, 0);
    }
}
