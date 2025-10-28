package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String ERR_IS_BLANK = "[ERROR]빈 값은 허용되지 않습니다.";
    private static final String REGEX = ",";

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

    private static boolean isBlank(String raw) {
        return raw == null || raw.isBlank();
    }

    private static String[] splitByRegex(String raw) {
        return raw.split(REGEX, -1);
    }


}
