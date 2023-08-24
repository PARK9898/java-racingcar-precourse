package racingcar.domain;

public class Car {

	private final String name;
	private int position = 0;

	public Car(String name) {
		this(name, 0);
	}

	public Car(String name, int position) {
		validateLength(name);
		this.name = name;
		this.position = position;
	}

	private void validateLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("이름은 5글자 이하입니다");
		}
	}

	public void moveBy(int number) {
		if (number >= 4) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
