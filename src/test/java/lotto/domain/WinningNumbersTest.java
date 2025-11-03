package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private static final String ERR_NUMBER_RANGE = "[ERROR] 1 ~ 45 사이의 숫자만 가능합니다.";
    private static final String ERR_DUPLICATE_NUMBERS = "[ERROR] 로또 번호는 중복되면 안됩니다.";
    private static final String ERR_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";

    @Test
    void 숫자_개수가_6개가_아니면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_LOTTO_SIZE);
    }

    @Test
    void 범위가_1에서_45사이가_아니면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_NUMBER_RANGE);
    }

    @Test
    void 중복되는_숫자가_있으면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_DUPLICATE_NUMBERS);
    }

    @Test
    void 범위가_1에서_45사이인_서로_다른_6개의_숫자인_경우_생성() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 45));
        assertThat(winningNumbers.getClass()).isEqualTo(WinningNumbers.class);
    }


}