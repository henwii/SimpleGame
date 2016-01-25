package com.mygdx.simplegame.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.simplegame.gameobjects.Runner;
import com.mygdx.simplegame.gameobjects.arraylists.Platforms;
import com.mygdx.simplegame.gameobjects.arraylists.PowerUps;
import com.mygdx.simplegame.helpers.BackgroundLoader;
import com.mygdx.simplegame.helpers.Input;

import java.util.ArrayList;

/**
 * Created by Besten on 2016-01-23.
 */
public class GameWorld {

    Runner runner = new Runner();
    BackgroundLoader backgroundLoader = new BackgroundLoader();
    Input input = new Input(runner);

    ArrayList<Platforms> platforms = new ArrayList<Platforms>();
    ArrayList<PowerUps> powers = new ArrayList<PowerUps>();

    private BitmapFont font;
    int score = 0;
    int maxScore = 10;

    boolean VY_NEGATIVE;

    public GameWorld() {
        Gdx.input.setInputProcessor(input);
        for(int i = 0; i < 10; i++){
            platforms.add(new Platforms((int) (1920 + 2000 * Math.random()), ((int) (200 + 700 * Math.random()))));
        }
        for(int i = 0; i < maxScore; i++){
            powers.add(new PowerUps((int) (1920 + 10000 * Math.random()), ((int) (200 + 700 * Math.random()))));
        }
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(3,3);
    }

    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        backgroundLoader.draw(batch);

        for(Platforms platform: platforms){
            platform.draw(batch);
        }

        runner.draw(batch, shapeRenderer);
        for(PowerUps power: powers){
            power.draw(batch);
        }
        drawScore(batch);
    }

    private void drawScore(SpriteBatch batch) {
        batch.begin();
        font.draw(batch, "Score:" + score + "/10 " , 200, 1000);
        if(score == maxScore){
            font.draw(batch,"YOU WON!",850,530);
        }
        batch.end();
    }

    public void update(float delta) {
        runner.update(delta);
        backgroundLoader.update(delta);
        for(Platforms platform: platforms){
            platform.update(delta);
        }
        for(PowerUps power: powers){
            power.update(delta);
        }

        checkVy();
        RunnerPlatformCollision();
        RunnerCoinCollision();
    }



    private void checkVy() {
        if(runner.vy < 0){
            VY_NEGATIVE = true;
        }else{
            VY_NEGATIVE = false;
        }
    }

    private void RunnerPlatformCollision() {
        for(Platforms platform: platforms){
            if(VY_NEGATIVE == true){
                if(runner.x >= platform.x && runner.x <= platform.x + platform.width &&
                        runner.y >= platform.y &&
                        runner.y <= platform.y + platform.height){
                    runner.y = platform.y + platform.height;
                    runner.vy  = 0;
                    runner.count = 0;
                }
            }
        }
    }
    private void RunnerCoinCollision() {
        for(PowerUps power: powers){
            if(runner.x + runner.width >= power.x && runner.x <= power.x + power.width &&
                    runner.y + runner.height >= power.y && runner.y <= power.y + power.height){
                power.x =  50;
                power.y = 1400;
                power.a = 0;
                power.vx = 0;
                power.vy = 0;
                score++;
            }
        }
    }
}
