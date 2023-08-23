package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.InputView;

public class RacingManager {

	private static List<Car> carList = new ArrayList<>();

	private final CarName carName;


	public RacingManager() {
		carName = new CarName();
	}

	public List<Car> pickWinner(List<Car> carList1) {
		int highestPosition = carList.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);

		List<Car> winner = carList.stream()
			.filter(car -> car.getPosition() == highestPosition)
			.collect(Collectors.toList());

		return winner;
	}

	public List<Car> settingCar(String carNames) {

		List<String> carNameList = carName.splitCarName(carNames);
		carName.validateCarName(carNameList);

		for(int i = 0; i < carNameList.size(); i++) {
			carList.add(new Car(carNameList.get(i)));
		}
		return carList;
	}

}
