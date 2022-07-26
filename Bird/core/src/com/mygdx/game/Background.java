package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class BGImage {
        private Texture image;
        private Vector2 position;
        public BGImage(Vector2 position) {
            image = new Texture("back.png");
            this.position = position;
        }
    }

    private int speed;
    private BGImage[] backs;

    public Background() {
        speed = 4;
        backs = new BGImage[2];
        backs[0] = new BGImage(new Vector2(0,0));
        backs[1] = new BGImage(new Vector2(800,0));
    }
    public void render(SpriteBatch batch) {
        for (int i = 0; i < backs.length; i++) {
            batch.draw(backs[i].image, backs[i].position.x, backs[i].position.y);
        }
    }
    public void update() {
        backs[0].position.x -= speed;
        backs[1].position.x -= speed;
        if(backs[0].position.x < -800) {
            backs[0].position.x = 0;
            backs[1].position.x = 800;
        }
    }
}
