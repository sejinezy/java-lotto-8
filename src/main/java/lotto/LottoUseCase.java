package lotto;

import lotto.domain.LottoCart;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.service.LottoGame;
import lotto.domain.ResultSheet;

public class LottoUseCase {

    private final LottoGenerator lottoGenerator;
    private final LottoGame lottoGame;

    public LottoUseCase(LottoGenerator lottoGenerator, LottoGame lottoGame) {
        this.lottoGenerator = lottoGenerator;
        this.lottoGame = lottoGame;
    }

    public LottoCart generateLottoCart(PurchaseAmount purchaseAmount) {
        return lottoGenerator.generateLottoCart(purchaseAmount);
    }

    public double calculateRateOfReturn(ResultSheet resultSheet, PurchaseAmount purchaseAmount) {
        return lottoGame.calculateRateOfReturn(purchaseAmount, resultSheet);
    }

    public ResultSheet compare(WinningLotto winningLotto, LottoCart lottoCart) {
        return lottoGame.compare(winningLotto, lottoCart);
    }

}
