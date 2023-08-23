package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import racingcar.domain.CarName;

public class CarNameTest {
	@Test
	@DisplayName("차 이름은 5자 이하여야한다")
	public void carNameTest() {
		CarName carName = new CarName();
		List<String> carNameList = new ArrayList<>();
		carNameList.add("asdjd");
		carNameList.add("dsjkald");

		Assertions.assertThrows(IllegalArgumentException.class,() -> carName.validateCarName(carNameList));
	}

	@Test
	@DisplayName("차 이름은 중복되면 안된다")
	public void nameDuplicateTest() {
		CarName carName = new CarName();
		List<String> carNameList = new ArrayList<>();
		carNameList.add("abcd");
		carNameList.add("abcd");

		Assertions.assertThrows(IllegalArgumentException.class, () -> carName.duplicateName(carNameList));
	}

	@Test
	@DisplayName("차 이름은 쉼표기준으로 나뉘어야합니다")
	public void splitCarNameTest() {
		CarName carName = new CarName();
		String carNames = "abcd,efg,hijk";
		List<String> carNames1 = new ArrayList<>();
		List<String> carNames2 = new ArrayList<>();

		carNames1.add("abcd");
		carNames1.add("efg");
		carNames1.add("hijk");

		carNames2 = carName.splitCarName(carNames);

		assertThat(carNames1).isEqualTo(carNames2);

	}
}
