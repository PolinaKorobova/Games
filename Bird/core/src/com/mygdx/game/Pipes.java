package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Pipes {
    class PipesPairs {
        Vector2 position;
        float speed;
        int ofset;
        Rectangle empySpase;

        public PipesPairs(Vector2 pos) {
            position = pos;
            speed = 2;
            ofset = new Random().nextInt(170);
            empySpase = new Rectangle(position.x, position.y - ofset + 180, 30, distance);
        }
        public void update() {
            position.x -= speed;
            if(position.x < -30) {
                position.x = 800;
                ofset = new Random().nextInt(170);
            }
            empySpase.x = position.x;
        }
    }

    static PipesPairs[] pairs;
    Texture texture;
    int distance;

    public Pipes() {
        texture = new Texture("obs.png");
        pairs = new PipesPairs[4];
        distance = 270;
        int startPosition = 500;
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new PipesPairs(new Vector2(startPosition, 0));
            startPosition += 220;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < pairs.length; i++) {
            batch.draw(texture, pairs[i].position.x, pairs[i].position.y);
            batch.draw(texture, pairs[i].position.x,
                    pairs[i].position.y + distance + texture.getHeight() - pairs[i].ofset);
        }
    }

    public void update() {
        for (int i = 0; i < pairs.length; i++) {
            pairs[i].update();
        }
    }

    public void recreate() {
        int startPosition = 500;
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new PipesPairs(new Vector2(startPosition, 0));
            startPosition += 220;
        }
    }
}
