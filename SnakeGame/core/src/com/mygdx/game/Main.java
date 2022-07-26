package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Apple apple;
	Snake snake;
	float currentTime = 0;
	float period = 0.35f;
	boolean gamePlay = true;
	Texture gameover;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		apple = new Apple();
		snake = new Snake();
		gameover = new Texture("gameover.jpg");
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		if(gamePlay) {
			background.render(batch);
			apple.render(batch);
			snake.render(batch);
		}
		else {
			batch.draw(gameover, 0, 0);
			if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
				gamePlay = true;
				recreate();
			}
		}
		batch.end();
	}

	public void update() {
			background.update();
			snake.keyboard();
			currentTime += Gdx.graphics.getDeltaTime();
			if (currentTime > period) {
				currentTime -= period;
				if (snake.x[0] == apple.appleX && snake.y[0] == apple.appleY) {
					snake.snake_length++;
					apple.update();
				}
				snake.update();
				for (int i = snake.snake_length - 1; i > 0; i--) {
					if(snake.x[0] == snake.x[i] && snake.y[0] == snake.y[i]) { gamePlay = false; }
				}
				if(snake.x[0] > background.image.texture.getWidth() ||
						snake.x[0] < 0 ||
						snake.y[0] > background.image.texture.getHeight() ||
						snake.y[0] < 0 ) { gamePlay = false; }
			}
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}

	public void recreate() {
		apple.recreate();
		snake.recreate();
	}
}
