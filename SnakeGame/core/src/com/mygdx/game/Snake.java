package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Snake {
    Texture texture;
    int snake_length = 3;
    int allSize = 500;
    int[] x = new int[allSize];
    int[] y = new int[allSize];
    boolean right = true;
    boolean left = false;
    boolean up = false;
    boolean down = false;

    public Snake() {
        texture = new Texture("snakee.png");
        for (int i = snake_length-1; i >= 0; i--) {
            x[i] = 100 - i*texture.getHeight();
            y[i] = 100;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = snake_length-1; i >= 0; i--) {
            batch.draw(texture, x[i], y[i]);
        }
    }

    public void update() {
        for (int i = snake_length-1; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if(right) { x[0] += 20; }
        if(left) { x[0] -= 20; }
        if(up) { y[0] += 20; }
        if(down) { y[0] -= 20; }
    }

    public void keyboard() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && !right) {
            left = true;
            down = false;
            up = false;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !left) {
            right = true;
            down = false;
            up = false;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && !down) {
            left = false;
            right = false;
            up = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && !up) {
            left = false;
            down = true;
            right = false;
        }
    }

    public void recreate() {
        snake_length = 3;
        right = true;
        left = false;
        up = false;
        down = false;
        for (int i = snake_length-1; i >= 0; i--) {
            x[i] = 100 - i*texture.getHeight();
            y[i] = 100;
        }
    }
}
