package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    private final static String ERR_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000단위만 가능합니다.";

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(1100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_AMOUNT_UNIT);

        assertThatThrownBy(() -> new PurchaseAmount(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_AMOUNT_UNIT);

        assertThatThrownBy(() -> new PurchaseAmount(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERR_AMOUNT_UNIT);
    }

    @Test
    void 구입_금액이_1000원_단위이면_생성() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        assertThat(purchaseAmount.getAmount()).isEqualTo(1000);
        assertThat(purchaseAmount.getAmount() % 1000).isEqualTo(0);

        PurchaseAmount purchaseAmount2 = new PurchaseAmount(2000);
        assertThat(purchaseAmount2.getAmount()).isEqualTo(2000);
        assertThat(purchaseAmount2.getAmount() % 1000).isEqualTo(0);

    }

    @Test
    void 구입_금액에_따라_구매_로또_개수를_계산한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        int count = purchaseAmount.calculateLottoCount();

        assertThat(count).isEqualTo(8);

    }

}