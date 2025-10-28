package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {

    private final static String ERROR_NUMBER_TYPE = "[ERROR] 정수 숫자만 가능합니다.";
    private static final String ERR_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERR_NUMBER_RANGE = "[ERROR] 1 ~ 45 사이의 숫자만 가능합니다.";

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<String> winningNumbersInput) {
        List<Integer> numbers = parseInteger(winningNumbersInput);
        validateSize(numbers);
        checkNumbersRange(numbers);
        winningNumbers = numbers;
    }

    private List<Integer> parseInteger(List<String> winningNumbersInput) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String number : winningNumbersInput) {
                numbers.add(Integer.parseInt(number));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_TYPE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERR_LOTTO_SIZE);
        }
    }

    private void checkNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }

    }

    private void validateRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERR_NUMBER_RANGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
