package com.mygdx.simplegame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.simplegame.worlds.GameWorld;

/**
 * Created by Besten on 2016-01-23.
 */
public class GameScreen implements Screen {

    OrthographicCamera cam;
    SpriteBatch batch;
    GameWorld world;
    ShapeRenderer shapeRenderer;
    int SCREEN_WIDTH = 1920;
    int SCREEN_HEIGHT = 1080;

    public GameScreen(){
        cam = new OrthographicCamera();
        cam.setToOrtho(true,SCREEN_WIDTH,SCREEN_HEIGHT);
        batch = new SpriteBatch();
        world = new GameWorld();
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Bg-color
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(0, 0, 1920, 1080);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.end();

        world.update(delta);
        world.draw(batch,shapeRenderer);
    }

    @Override
    public void show() {

    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        batch.dispose();
    }
}
