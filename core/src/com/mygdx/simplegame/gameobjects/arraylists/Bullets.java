package com.mygdx.simplegame.gameobjects.arraylists;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Besten on 2016-01-26.
 */
public class Bullets {

    public int x,y;
    public int width = 40;
    public int height = 150;
    public double vx = -10 ,vy = 0;
    Texture bulletTexture;

    public Bullets(int x0, int y0){
        int x = x0;
        int y = y0;
        bulletTexture = new Texture(Gdx.files.internal("bullet.png"));
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(bulletTexture,x,y,width,height);
        batch.end();
    }

    public void update(float delta) {
        x += vx;
        y += vy;
    }
}
