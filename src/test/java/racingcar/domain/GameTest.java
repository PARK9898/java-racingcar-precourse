package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	public void 이름을_받아서_자동차를_생성한다() {
		List<String> carNames = new ArrayList<>();
		carNames.add("park");
		carNames.add("jung");

		Game game = Game.of(carNames);

		List<Car> cars = game.getCars();
		assertThat(cars.get(0).getName()).isEqualTo("park");
		assertThat(cars.get(1).getName()).isEqualTo("jung");
	}

	@Test
	void 게임을_한_번_실행한다() {
		List<String> carNames = new ArrayList<>();
		carNames.add("park");
		carNames.add("jung");
		Game game = Game.of(carNames);

		game.runOnce(() -> 5);

		List<Car> cars = game.getCars();
		assertThat(cars.get(0).getPosition()).isEqualTo(1);
		assertThat(cars.get(1).getPosition()).isEqualTo(1);
	}

	@Test
	void 우승자를_결정한다() {
		Car winner = new Car("주호", 5);
		Game game = new Game(Arrays.asList(
			new Car("정언", 2),
			new Car("성철", 3),
			winner
		));

		assertThat(game.getWinners()).containsOnly(winner);
	}
}