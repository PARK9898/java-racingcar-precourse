package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final List<Car> carList;

	public Game(List<Car> carList) {
		this.carList = carList;
	}

	public static Game of(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return new Game(cars);
	}

	public List<Car> getCars() {
		return carList;
	}

	public void runOnce(NumberGenerator numberGenerator) {
		for (Car car : carList) {
			int number = numberGenerator.generate();
			car.moveBy(number);
		}
	}

	public List<Car> getWinners() {

		int highest = 0;
		List<Car> winners = new ArrayList<>();

		for (Car car : carList) {
			highest = Math.max(highest, car.getPosition());
		}

		for (Car car : carList) {
			if (car.getPosition() == highest) {
				winners.add(car);
			}
		}

		return winners;
	}
}
