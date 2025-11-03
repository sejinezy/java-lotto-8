package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCart;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    void 로또카트의_로또들과_당첨번호를_비교한다() {
        WinningLotto winningLotto = new WinningLotto(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Lotto FirstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto FifthLotto = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        LottoCart lottoCart = new LottoCart(
                List.of(FirstLotto, FifthLotto));

        ResultSheet resultSheet = new LottoGame().compare(winningLotto, lottoCart);

        assertThat(resultSheet.getResultSheet().get(Rank.FIFTH)).isEqualTo(1);
        assertThat(resultSheet.getResultSheet().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(resultSheet.getResultSheet().get(Rank.THIRD)).isEqualTo(0);
        assertThat(resultSheet.getResultSheet().get(Rank.SECOND)).isEqualTo(0);
        assertThat(resultSheet.getResultSheet().get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 수익률을_계산한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        ResultSheet resultSheet = new ResultSheet();
        resultSheet.increase(Rank.FIFTH);

        LottoGame lottoGame = new LottoGame();
        double rateOfReturn = lottoGame.calculateRateOfReturn(purchaseAmount, resultSheet);

        assertThat(rateOfReturn).isEqualTo(62.5);

    }

}