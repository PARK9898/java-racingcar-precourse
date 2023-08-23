package racingcar;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.MoveDecision;
import racingcar.domain.RacingManager;
import racingcar.view.InputView;

public class RacingManagerTest {
	@Test
	@DisplayName("차 세팅 테스트")
	public void settingCarTest() {
		RacingManager racingManager;
		racingManager = new RacingManager();

		List<Car> carList = new ArrayList<>();

		carList = racingManager.settingCar("abcd,efg,hijk");

		Assertions.assertThat(carList.get(0).getName()).isEqualTo("abcd");
		Assertions.assertThat(carList.get(1).getName()).isEqualTo("efg");
		Assertions.assertThat(carList.get(2).getName()).isEqualTo("hijk");
	}

	@Test
	@DisplayName("우승자 선택 테스트")
	public void pickWinnerTest() {
		RacingManager racingManager;
		racingManager = new RacingManager();
		List<Car> carList1 = new ArrayList<>();
		List<Car> carList2 = new ArrayList<>();
		List<Car> carList3 = new ArrayList<>();

 		carList1 = racingManager.settingCar("abcd,efg,hijk");

		for (int i = 0; i < 3; i++) {
			carList1.get(0).move(true);
			carList1.get(1).move(true);
		}

		for (int i = 0; i < 2; i++) {
			carList1.get(2).move(true);
		}
		carList3.add(carList1.get(0));
		carList3.add(carList1.get(1));

		carList2 = racingManager.pickWinner(carList1);

		Assertions.assertThat(carList2).isEqualTo(carList3);
	}
}
