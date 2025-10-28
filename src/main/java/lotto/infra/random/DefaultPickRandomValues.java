package lotto.infra.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.port.PickRandomNumbers;

public class DefaultPickRandomValues implements PickRandomNumbers {

    @Override
    public List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
