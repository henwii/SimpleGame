package com.mygdx.simplegame.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.simplegame.gameobjects.Runner;
import com.mygdx.simplegame.gameobjects.platforms.Platforms;
import com.mygdx.simplegame.helpers.BackgroundLoader;
import com.mygdx.simplegame.helpers.Input;

import java.util.ArrayList;

/**
 * Created by Besten on 2016-01-23.
 */
public class GameWorld {

    ArrayList<Platforms> platforms = new ArrayList<Platforms>();
    Runner runner = new Runner();
    BackgroundLoader backgroundLoader = new BackgroundLoader();
    boolean VY_NEGATIVE;


    Input input = new Input(runner);

    public GameWorld() {
        Gdx.input.setInputProcessor(input);
        for(int i = 0; i < 20; i++){
            platforms.add(new Platforms((int) (1920 + 2000 * Math.random()), ((int) (200 + 700 * Math.random()))));
        }
    }

    public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        backgroundLoader.draw(batch);


        for(Platforms platform: platforms){
            platform.draw(batch);
        }
        runner.draw(batch, shapeRenderer);
    }

    public void update(float delta) {
        runner.update(delta);
        backgroundLoader.update(delta);
        for(Platforms platform: platforms){
            platform.update(delta);
        }
        checkVy();
        collision();
    }

    private void checkVy() {
        if(runner.vy < 0){
            VY_NEGATIVE = true;
        }else{
            VY_NEGATIVE = false;
        }
    }

    private void collision() {
        for(Platforms platform: platforms)
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
