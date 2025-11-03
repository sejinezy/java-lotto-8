package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private static final String ERR_NUMBERS_DUPLICATION = "[ERROR] 중복된 값이 있습니다.";

    @Test
    void 당첨_번호와_보너스_번호는_서로_중복되면_안된다() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_NUMBERS_DUPLICATION);
    }

    @Test
    void 당첨_번호와_보너스_번호가_중복되지_않으면_생성() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        assertThat(winningLotto.getClass()).isEqualTo(WinningLotto.class);
    }

}