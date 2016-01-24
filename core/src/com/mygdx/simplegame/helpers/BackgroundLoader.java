package com.mygdx.simplegame.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Besten on 2016-01-24.
 */
public class BackgroundLoader {
    Texture Grass1Texture = new Texture(Gdx.files.internal("grass1.png"));
    Texture Grass2Texture = new Texture(Gdx.files.internal("grass2.png"));
    Texture bg1Texture = new Texture(Gdx.files.internal("bg1.png"));
    Texture bg2Texture = new Texture(Gdx.files.internal("bg2.png"));
    Texture bg3Texture = new Texture(Gdx.files.internal("bg3.png"));
    int bg1_x = 0;
    int bg1_y = 0;
    int bg2_x = 1920;
    int bg2_y = 0;
    int bg3_x = 3840;
    int bg3_y = 0;
    int grass1_x = 0;
    int grass1_y = 0;
    int grass2_x = 1920;
    int grass2_y = 0;

    double bg_vx = -1;
    double grass_vx = -10;

    public void draw(SpriteBatch batch) {
        drawBackground(batch);
        drawGround(batch);
    }

    public void update(float delta) {

        bg1_x += bg_vx;
        bg2_x += bg_vx;
        bg3_x += bg_vx;

        grass1_x += grass_vx;
        grass2_x += grass_vx;
        returnBackground();
    }

    private void returnBackground() {
        if(bg1_x < -1920){
            bg1_x = 1910;
        }
        if(bg2_x < -1920){
            bg2_x = 1910;
        }
        if(bg3_x < -1920){
            bg3_x = 1910;
        }
        if(grass1_x < -1920){
            grass1_x = 1910;
        }
        if(grass2_x < -1920){
            grass2_x = 1910;
        }
    }

    private void drawBackground(SpriteBatch batch) {
        batch.begin();
        batch.draw(bg1Texture, bg1_x, bg1_y, 1920, 1080);
        batch.end();

        batch.begin();
        batch.draw(bg2Texture,bg2_x,bg2_y,1920,1080);
        batch.end();

        batch.begin();
        batch.draw(bg3Texture,bg3_x,bg3_y,1920,1080);
        batch.end();
    }

    private void drawGround(SpriteBatch batch) {
        batch.begin();
        batch.draw(Grass1Texture, grass1_x, grass1_y, 1920, 100);
        batch.end();
        batch.begin();
        batch.draw(Grass2Texture, grass2_x, grass2_y, 1920, 100);
        batch.end();
    }
}
