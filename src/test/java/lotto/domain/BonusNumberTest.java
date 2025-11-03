package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BonusNumberTest {
    private static final String ERR_NUMBER_RANGE = "[ERROR] 1 ~ 45 사이의 숫자만 가능합니다.";

    @Test
    void 범위가_1에서_45사이의_숫자면_보너스번호_생성() {
        BonusNumber bonusNumber1 = new BonusNumber(1);
        BonusNumber bonusNumber2 = new BonusNumber(20);
        BonusNumber bonusNumber3 = new BonusNumber(45);
        assertThat(bonusNumber1.getBonus()).isEqualTo(1);
        assertThat(bonusNumber2.getBonus()).isEqualTo(20);
        assertThat(bonusNumber3.getBonus()).isEqualTo(45);
    }

    @Test
    void 보너스_번호가_1보다_작으면_예외_발생() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERR_NUMBER_RANGE);
    }

    @Test
    void 보너스_번호가_45보다_크면_예외_발생() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERR_NUMBER_RANGE);

    }

}
