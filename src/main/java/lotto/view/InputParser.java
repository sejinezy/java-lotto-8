package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String ERR_IS_BLANK = "빈 값은 허용되지 않습니다.";
    private static final String REGEX = ",";
    private final static String ERROR_NUMBER_TYPE = "정수 숫자만 가능합니다.";

    private InputParser() {

    }

    public static String validateBlank(String raw) {
        if (isBlank(raw)) {
            throw new IllegalArgumentException(ERR_IS_BLANK);
        }
        return raw.strip();
    }

    public static List<String> parseValidateNumbers(String raw) {
        validateBlank(raw);
        List<String> numbers = new ArrayList<>();

        String[] split = splitByRegex(raw);

        for (String number : split) {
            String validatedInput = validateBlank(number);
            numbers.add(validatedInput);
        }
        return numbers;
    }

    public static List<Integer> toInts(List<String> winningNumbersInput) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbersInput) {
            numbers.add(toInt(number));
        }
        return numbers;
    }

    public static int toInt(String bonusInput) {
        try {
            return Integer.parseInt(bonusInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_TYPE);
        }
    }

    private static boolean isBlank(String raw) {
        return raw == null || raw.isBlank();
    }

    private static String[] splitByRegex(String raw) {
        return raw.split(REGEX, -1);
    }
}
