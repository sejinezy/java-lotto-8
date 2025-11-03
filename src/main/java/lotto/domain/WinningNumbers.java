package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.domain.validator.Validator;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbersInput) {
        Validator.validateSize(winningNumbersInput);
        Validator.validateEachRange(winningNumbersInput);
        Validator.validateNoDuplicates(winningNumbersInput);
        winningNumbers = winningNumbersInput;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

}
