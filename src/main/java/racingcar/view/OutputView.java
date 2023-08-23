package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	private static final String POSITON = "-";

	public void gameResultPhrases() {
		System.out.println("실행결과: \n");
	}

	public void printGameProgress(List<Car> carList) {
		for(int j = 0; j < carList.size(); j++) {
			System.out.println(carList.get(j).getName() + ":" + printPosition(carList.get(j)));
		}
		System.out.println("");
	}

	public String printPosition(Car car) {
		String position = "";
		for(int i = 0; i < car.getPosition(); i++) {
			position += POSITON;
		}
		return position;
	}

	public void printWinner(List<Car> winner) {
		System.out.print("최종 우승자 : ");
		for(int i = 0; i < winner.size(); i++) {
			System.out.print(winner.get(i).getName());

			if(i < winner.size() -1) {
				System.out.print(",");
			}
		}
	}

}

