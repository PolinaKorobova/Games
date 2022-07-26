package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class BGImage {
        public Texture texture;
        public Vector2 position;

        public BGImage(Vector2 position) {
            this.position = position;
            texture = new Texture("back.jpg");
        }
    }

    BGImage image;
    public Background() {
        image = new BGImage(new Vector2(0, 0));
    }
    public void render(SpriteBatch batch) {
        batch.draw(image.texture, image.position.x, image.position.y);
    }
    public void update() {

    }
}
