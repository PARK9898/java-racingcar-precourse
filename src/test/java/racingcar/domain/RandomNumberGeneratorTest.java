package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

	@RepeatedTest(1000)
	public void 랜덤숫자는_0과9_사이이다() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

		Assertions.assertThat(randomNumberGenerator.generate()).isBetween(0, 9);
	}
}