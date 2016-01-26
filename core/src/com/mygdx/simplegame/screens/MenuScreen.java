package com.mygdx.simplegame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Besten on 2016-01-26.
 */
public class MenuScreen implements Screen {

    GameScreen gameScreen;
    OrthographicCamera cam;
    SpriteBatch batch;
    Texture playButton;
    Texture Background;

    int SCREEN_WIDTH = 1920;
    int SCREEN_HEIGHT = 1080;
    int PlayButton_WIDTH = 600;
    int PlayButton_HEIGHT = 200;
    int PlayButton_X = SCREEN_WIDTH/2 - PlayButton_WIDTH/2;
    int PlayButton_Y = SCREEN_HEIGHT/2 - PlayButton_HEIGHT/2;

    ShapeRenderer shapeRenderer;
    int count = 0;

    public MenuScreen(){
        gameScreen = new GameScreen();
        cam = new OrthographicCamera();
        cam.setToOrtho(true,SCREEN_WIDTH,SCREEN_HEIGHT);
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        playButton = new Texture(Gdx.files.internal("PlayButton.png"));
        Background = new Texture(Gdx.files.internal("MenuBackground.png"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        drawBackground();
        drawPlayButton();
        runButton(delta);
    }

    private void drawBackground() {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(Background, 0, 0, 1920, 1080);
        batch.end();
    }

    private void drawPlayButton() {
        batch.begin();
        batch.draw(playButton,PlayButton_X,PlayButton_Y,PlayButton_WIDTH,PlayButton_HEIGHT);
        batch.end();
    }

    private void runButton(float delta) {
        int touch_x = Gdx.input.getX();
        int touch_y = Gdx.input.getY();

        if(Gdx.input.isTouched()&& touch_x >= PlayButton_X && touch_x <= PlayButton_X + PlayButton_WIDTH &&
                touch_y >= PlayButton_Y && touch_y <= PlayButton_Y + PlayButton_WIDTH){
            count++;
        }

        if(count >= 1){
            gameScreen.render(delta);
        }
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
        batch.dispose();
        shapeRenderer.dispose();
    }
}
