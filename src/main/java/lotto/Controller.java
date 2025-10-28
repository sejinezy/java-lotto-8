package lotto;

import static lotto.view.InputParser.*;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoCart;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.port.PickRandomNumbers;
import lotto.service.LottoGame;
import lotto.service.ResultSheet;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final PickRandomNumbers pickRandomNumbers;
    private final OutputView outputView;

    public Controller(InputView inputView, PickRandomNumbers pickRandomNumbers, OutputView outputView) {
        this.inputView = inputView;
        this.pickRandomNumbers = pickRandomNumbers;
        this.outputView = outputView;
    }

    public void run() {
        String amountInput = validateBlank(inputView.purChaseAmountReadLine());
        PurchaseAmount purchaseAmount = new PurchaseAmount(amountInput);
        LottoGenerator lottoGenerator = new LottoGenerator(pickRandomNumbers);

        LottoCart lottoCart = lottoGenerator.generateLottoList(purchaseAmount);
        outputView.printLottoCount(lottoCart);
        outputView.printLottoCart(lottoCart);

        List<String> winningNumbersInput = parseValidateNumbers(inputView.winningNumbersReadLine());
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput);

        String bonusInput = validateBlank(inputView.bonusNumberReadLine());
        BonusNumber bonusNumber = new BonusNumber(bonusInput, winningNumbers);

        LottoGame lottoGame = new LottoGame();
        ResultSheet resultSheet = lottoGame.game(lottoCart, winningNumbers, bonusNumber);
        double rateOfReturn = lottoGame.calculateRateOfReturn(resultSheet,purchaseAmount);
        outputView.printWinningStatistics(resultSheet);
        outputView.printRateOfReturn(rateOfReturn);


    }
}
