package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.domain.validator.Validator;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbersInput) {
        Validator.size(winningNumbersInput);
        Validator.range(winningNumbersInput);
        Validator.duplication(winningNumbersInput);
        winningNumbers = winningNumbersInput;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

}
