package lotto.infra.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.port.PickRandomNumbers;

public class DefaultPickRandomValues implements PickRandomNumbers {

    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    @Override
    public List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_MIN, NUMBER_MAX, LOTTO_NUMBERS_SIZE);
    }
}
