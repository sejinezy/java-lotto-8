package lotto;

import lotto.domain.LottoCart;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.port.PickRandomNumbers;
import lotto.service.LottoGame;
import lotto.domain.ResultSheet;

public class LottoUseCase {

    private final PickRandomNumbers pickRandomNumbers;
    private final LottoGame lottoGame;

    public LottoUseCase(PickRandomNumbers pickRandomNumbers, LottoGame lottoGame) {
        this.pickRandomNumbers = pickRandomNumbers;
        this.lottoGame = lottoGame;
    }

    public LottoCart generateLottoCart(PurchaseAmount purchaseAmount) {
        LottoGenerator lottoGenerator = new LottoGenerator(pickRandomNumbers);
        return lottoGenerator.generateLottoCart(purchaseAmount);
    }

    public double calculateRateOfReturn(WinningLotto winningLotto, LottoCart lottoCart, PurchaseAmount purchaseAmount) {
        ResultSheet resultSheet = compare(winningLotto, lottoCart);
        return lottoGame.calculateRateOfReturn(purchaseAmount, resultSheet);
    }

    public ResultSheet compare(WinningLotto winningLotto, LottoCart lottoCart) {
        return lottoGame.compare(winningLotto, lottoCart);
    }

}
