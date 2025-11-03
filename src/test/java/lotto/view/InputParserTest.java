package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private static final String ERR_IS_BLANK = "빈 값은 허용되지 않습니다.";
    private final static String ERROR_NUMBER_TYPE = "정수 숫자만 가능합니다.";

    @Test
    void 빈_값이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> InputParser.validateBlank(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_IS_BLANK);

        assertThatThrownBy(() -> InputParser.validateBlank(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_IS_BLANK);

    }

    @Test
    void 문자열을_구분자로_나눈다() {
        List<String> numbers = InputParser.parseValidateNumbers("1,2,3,4,5,6");
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 정수_숫자가_아닌경우_예외_발생() {
        assertThatThrownBy(() -> InputParser.toInt("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NUMBER_TYPE);
    }

}