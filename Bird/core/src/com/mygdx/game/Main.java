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
	Bird bird;
	Pipes pipes;
	boolean gameOver;
	Texture restartGame;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		bird = new Bird();
		pipes = new Pipes();
		gameOver = false;
		restartGame = new Texture("restart.jpg");
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		background.render(batch);
		pipes.render(batch);
		if(!gameOver) {
			bird.render(batch);
		}
		else {
			batch.draw(restartGame, 100, 10);
		}
		batch.end();
	}

	public void update() {
		background.update();
		bird.update();
		pipes.update();
		for (int i = 0; i < Pipes.pairs.length; i++) {
			if(bird.position.x > Pipes.pairs[i].position.x && bird.position.x < Pipes.pairs[i].position.x + 30) {
				if(!Pipes.pairs[i].empySpase.contains(bird.position)) {
					gameOver = true;
				}
			}
		}
		if(bird.position.y < 0 || bird.position.y > 450) {
			gameOver = true;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
			recreate();
		}
	}
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void recreate() {
		bird.recreate();
		pipes.recreate();
		gameOver = false;
	}
}
