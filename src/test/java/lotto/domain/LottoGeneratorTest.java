package lotto.domain;

import lotto.domain.port.PickRandomNumbers;
import lotto.infra.random.DefaultPickRandomValues;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void 구매금액_만큼_로또를_생성한다() {
        PickRandomNumbers pickTestRandomNumbers = new DefaultPickRandomValues();
        LottoGenerator lottoGenerator = new LottoGenerator(pickTestRandomNumbers);
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        LottoCart lottoCart = lottoGenerator.generateLottoCart(purchaseAmount);

        Assertions.assertThat(lottoCart.lottoCart().size()).isEqualTo(8);
    }
}