package racingcar.controller;

import java.util.List;

import racingcar.domain.Game;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private final InputView inputView;
	private final OutputView outputView;
	private final RandomNumberGenerator randomNumberGenerator;

	public GameController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.randomNumberGenerator = new RandomNumberGenerator();
	}

	public void run() {
		Game game = makeGame();
		int tryNumber = getTryNumber();

		outputView.printResultPhrase();
		runGame(game, tryNumber);

		showResult(game);
	}

	private int getTryNumber() {
		try {
			return inputView.inputTryNumber();
		} catch (IllegalArgumentException exception) {
			outputView.printError(exception.getMessage());
			return getTryNumber();
		}
	}

	private Game makeGame() {
		try {
			List<String> carNames = inputView.inputCarNames();
			Game game = Game.of(carNames);
			return game;
		} catch (IllegalArgumentException exception) {
			outputView.printError(exception.getMessage());
			return makeGame();
		}
	}

	private void runGame(Game game, int tryNumber) {
		for (int i = 0; i < tryNumber; i++) {
			game.runOnce(randomNumberGenerator);
			outputView.printCarsPosition(game.getCars());
		}
	}

	private void showResult(Game game) {
		outputView.printWinner(game.getWinners());
	}
}
