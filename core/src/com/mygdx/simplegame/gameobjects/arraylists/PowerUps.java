package com.mygdx.simplegame.gameobjects.arraylists;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Besten on 2016-01-25.
 */
public class PowerUps {

    public int x,y;
    public int width = 40;
    public int height = 40;
    public double vx = -2 - 2 * Math.random();
    public double vy;
    public double a = 0.2 + 1 * Math.random();
    Texture coinTexture;

    public PowerUps(int x0, int y0){
        x = x0;
        y = y0;
        coinTexture = new Texture(Gdx.files.internal("coin.png"));
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(coinTexture, x, (float) (y + 20 - 40 * Math.sin(a)), width, height);
        batch.end();
    }

    public void update(float delta) {
        a += 0.1;
        x += vx;
        y += vy;
        returnPowerUps();
    }

    private void returnPowerUps() {
        if( x < -20){
            x = (int) (1920 + 10000 * Math.random());
            y = (int) (200 + 700 * Math.random());
        }
    }
}
