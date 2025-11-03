package lotto.domain.validator;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final String ERR_NUMBER_RANGE = "[ERROR] 1 ~ 45 사이의 숫자만 가능합니다.";
    private static final String ERR_DUPLICATE_NUMBERS = "[ERROR] 로또 번호는 중복되면 안됩니다.";
    private static final String ERR_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";

    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private Validator() {
    }

    public static void range(Integer number) {
        if (number < NUMBER_MIN || number > NUMBER_MAX) {
            throw new IllegalArgumentException(ERR_NUMBER_RANGE);
        }
    }

    public static void range(List<Integer> numbers) {
        for (Integer number : numbers) {
            range(number);
        }
    }

    public static void duplication(List<Integer> numbers) {
        if (!isUnique(numbers)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_NUMBERS);
        }
    }

    private static boolean isUnique(List<Integer> numbers) {
        return numbers.size() == new HashSet<>(numbers).size();
    }

    public static void size(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERR_LOTTO_SIZE);
        }
    }
}
