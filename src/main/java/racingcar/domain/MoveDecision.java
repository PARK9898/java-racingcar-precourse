package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveDecision {

	public int makeRandomNumber() {
		  int randomNumber = Randoms.pickNumberInRange(0,9);
		  return randomNumber;
	}

	public boolean moveable() {
		if(makeRandomNumber() > 4)
			return true;
		return false;
	}
}
