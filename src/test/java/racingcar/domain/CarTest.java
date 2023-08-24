package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void 이름이_5글자가_넘으면_예외를_던진다() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Car("박정언바보멍"))
			.withMessage("이름은 5글자 이하입니다");
	}

	@Test
	void 주어진_숫자가_4_이상이면_전진한다() {
		Car car = new Car("정언");

		car.moveBy(4);

		assertThat(car.getPosition()).isOne();
	}

	@Test
	void 주어진_숫자가_3_이하이면_전진하지_않는다() {
		Car car = new Car("정언");

		car.moveBy(3);

		assertThat(car.getPosition()).isZero();
	}
}