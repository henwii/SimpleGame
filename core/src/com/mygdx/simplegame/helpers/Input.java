package com.mygdx.simplegame.helpers;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.simplegame.gameobjects.Runner;

/**
 * Created by Besten on 2016-01-23.
 */
public class Input implements InputProcessor{

    public Runner runner;

    public Input(Runner runner){
        this.runner = runner;
    }



    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        runner.count++;
        if(runner.count <=2){
            runner.jump();
        }else {

        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
