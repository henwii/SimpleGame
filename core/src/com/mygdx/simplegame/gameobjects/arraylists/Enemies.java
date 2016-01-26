package com.mygdx.simplegame.gameobjects.arraylists;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Besten on 2016-01-26.
 */
public class Enemies {
    public int x,y;
    public int width = 40;
    public int height = 200;
    public double vx = -10;
    public double vy = 0;
    Texture enemyTexture;

    public Enemies(int x0, int y0){
        x = x0;
        y = y0;
        enemyTexture = new Texture(Gdx.files.internal("enemy.png"));
    }

    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        batch.begin();
        batch.draw(enemyTexture, x, y, width, height);
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }

    public void update(float delta) {
        moveEnemy();
        returnEnemy();
    }

    private void returnEnemy() {
        if(x < -width){
            x = (int) (1920 + 15000 * Math.random());
        }
    }

    private void moveEnemy() {
        x += vx;
        y += vy;
    }
}
