package com.mygdx.simplegame.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;



/**
 * Created by Besten on 2016-01-23.
 */
public class Runner {

    public int x = 600;
    public int y = 300;
    public int width = 25;
    public int height = 120;
    public double vx = 0;
    public double vy = 0;
    public double gravity = -0.5;
    Texture RunnerTexture;
    TextureRegion[] animationFrames;
    Animation animation;
    float elapsedTime;

    public int count = 0;

    public Runner(){
        RunnerTexture = new Texture(Gdx.files.internal("runnerTexture2.png"));
        TextureRegion [][] tmpFrames = TextureRegion.split(RunnerTexture,36,123);
        animationFrames = new TextureRegion[4];
        int index = 0;
        for (int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                animationFrames[index++] = tmpFrames[i][j];
            }
        }
        animation = new Animation(0.1f,animationFrames);
    }

    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        //hitbox
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.end();

        batch.begin();
        batch.draw(animation.getKeyFrame(elapsedTime, true), x-5, y);
        batch.end();
    }

    public void update(float delta) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        moveRunner();
        checkGround();
    }

    private void moveRunner() {
        x += vx;
        y += vy;
        vy += gravity;
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
