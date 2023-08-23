package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


	public String inputNames() {

		String carNames;

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
		carNames = Console.readLine();

		List<String> carNameList = List.of(carNames.split(","));


		return carNames;
	}

	public int inPutTryNumber() {
		String inPutTryNumber;
		int tryNumber;

		System.out.println("시도할 회수는 몇회인가요?\n");
		inPutTryNumber = Console.readLine();

		tryNumber =validateTryNumber(inPutTryNumber);

		return tryNumber;
	}

	public int validateTryNumber(String inPutTryNumber) {
		int tryNumber;
		try {
			tryNumber = Integer.parseInt(inPutTryNumber);
			return tryNumber;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("문자가 아닌 숫자를 입력해주세요.");
		}
	}

}
