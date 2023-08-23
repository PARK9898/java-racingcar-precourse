package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarName {
	private static final int MAX_LENGTH = 5;

	public List<String> splitCarName(String carNames) {
		List<String> carNameList = List.of(carNames.split(","));
		return carNameList;
	}

	public void validateCarName(List<String> carNameList) {
		carNameList.stream()
			.filter(name -> name.length() > MAX_LENGTH)
			.forEach(name -> {
				throw new IllegalArgumentException("[ERROR] : 자동차 이름은 5자 이하여야 합니다");
			});
	}

	public void duplicateName(List<String> carNameList) {
		Set<String> NameSet = new HashSet<>();

		carNameList.stream().forEach(name -> {
			if (!NameSet.add(name)) {
				throw new IllegalArgumentException("[ERROR] : 중복된 자동차 이름이 있습니다.");
			}
		});
	}
}
