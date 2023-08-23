package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.RacingManager;
import racingcar.view.InputView;

public class GameController {
	private final Game game;

	public GameController() {
		game = new Game();
	}

	public void startGame() {
		game.startRace();
	}
}
