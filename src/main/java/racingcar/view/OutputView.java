package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class OutputView {
	private static final String POSITION = "-";

	public void printResultPhrase() {
		System.out.println("실행 결과 :");
	}

	public void printCarsPosition(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + stackPosition(car));
		}
		System.out.println();
	}

	public void printWinner(List<Car> winners) {
		String winnerNames = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(","));
		System.out.println("최종 우승자 : " + winnerNames);
	}

	public void printError(String message) {
		System.out.println("[ERROR] " + message);
	}

	private String stackPosition(Car car) {
		String position = "";
		for (int i = 0; i < car.getPosition(); i++) {
			position += POSITION;
		}
		return position;
	}

}
