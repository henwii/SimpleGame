package com.mygdx.simplegame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.simplegame.helpers.Input;

import javafx.scene.transform.Rotate;

/**
 * Created by Besten on 2016-01-23.
 */
public class Runner {

    public int x = 600;
    public int y = 800;
    public int width = 150;
    public int height = 150;
    public double vx = 0;
    public double vy = 0;
    public double gravity = -0.5;
    Texture RunnerTexture;
    public int count = 0;



    public Runner(){
        RunnerTexture = new Texture(Gdx.files.internal("runner2.png"));
    }

    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        batch.begin();
        batch.draw(RunnerTexture, x - width/2, y - 15, width, height);
        batch.end();
    }

    public void update(float delta) {
        x += vx;
        y += vy;

        vy += gravity;
        checkGround();
    }

    private void checkGround() {
        if(y < 55){
            y = 55;
            vy = -vy/2;
            count = 0;
        }
    }

    public void jump() {
        vy = 15;
    }
}
