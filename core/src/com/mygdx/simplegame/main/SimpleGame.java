package com.mygdx.simplegame.main;

import com.badlogic.gdx.Game;
import com.mygdx.simplegame.screens.GameScreen;

public class SimpleGame extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
