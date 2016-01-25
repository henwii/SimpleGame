package com.mygdx.simplegame.gameobjects.arraylists;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Besten on 2016-01-23.
 */
public class Platforms {

    public int x,y;
    public int width = (int) (100 + 300 * Math.random());
    public int height = 25;
    public double vx = - 10;
    public int vy = 0;
    private Texture PlatformTexture;

    public Platforms(int x0, int y0){
        x = x0;
        y = y0;

        switch((int) (1 + 2 * Math.random())){
            case 1:
                PlatformTexture = new Texture(Gdx.files.internal("platform.png"));
                break;
            case 2:
                PlatformTexture = new Texture(Gdx.files.internal("platform2.png"));
                break;
        }
    }


    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(PlatformTexture, x, y, width, height);
        batch.end();
    }

    public void update(float delta) {
        x += vx;
        y += vy;

        returnPlatform();
    }

    private void returnPlatform() {
        if(x < -width){
            x = (int) (1920 + 300 * Math.random());
            y = (int) (200 + 700 * Math.random());
            width = (int)(100 + 300 * Math.random());
        }
    }

}
