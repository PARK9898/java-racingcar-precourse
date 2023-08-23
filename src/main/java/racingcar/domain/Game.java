package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

	private final RacingManager racingManager;
	private final InputView inputView;
	private final MoveDecision moveDecision;
	private final OutputView outputView;

	public Game() {
		racingManager = new RacingManager();
		inputView = new InputView();
		moveDecision = new MoveDecision();
		outputView = new OutputView();
	}

	public void startRace() {
		int tryNumber;

		String carNames;

		List<Car> carList = new ArrayList<>();
		List<Car> winner = new ArrayList<>();

		carNames = inputView.inputNames();
		tryNumber = inputView.inPutTryNumber();

		carList = racingManager.settingCar(carNames);

		outputView.gameResultPhrases();

		for(int i = 0; i < tryNumber; i++) {
			raceOnce(carList);
			outputView.printGameProgress(carList);
		}

		winner = racingManager.pickWinner(carList);

		outputView.printWinner(winner);
	}

	private void raceOnce(List<Car> carList) {
		for(int i = 0; i < carList.size(); i++){
			carList.get(i).move(moveDecision.moveable());
		}
	}
}
