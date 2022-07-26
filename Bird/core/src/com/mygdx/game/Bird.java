package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {

    Texture image;
    Vector2 position;
    float vy;
    float gravity;

    public Bird() {
        image = new Texture("Bi.png");
        position = new Vector2(100, 200);
        vy = 0;
        gravity = -0.5f;
    }
    public void render(SpriteBatch batch) {

        batch.draw(image, position.x, position.y);
    }
    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy = 8;
        }
        vy += gravity;
        position.y += vy;
    }

    public void recreate() {
        position = new Vector2(100, 200);
        vy = 0;
    }
}
