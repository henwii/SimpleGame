package com.mygdx.simplegame.gameobjects.arraylists;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Besten on 2016-01-26.
 */
public class Enemies {
    public int x,y;
    public int width = 30;
    public int height = 30;
    public double vx;
    public double vy;
    Texture enemyTexture;

    public Enemies(int x0, int y0){
        x = x0;
        y = y0;
        enemyTexture = new Texture(Gdx.files.internal(""));
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(enemyTexture, x, y, width, height);
        batch.end();
    }

    public void update(float delta) {
        moveEnemy();
    }

    private void moveEnemy() {
        x += vx;
        y += vy;
    }
}
