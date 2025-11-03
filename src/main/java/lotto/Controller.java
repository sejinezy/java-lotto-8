package lotto;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoCart;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import lotto.domain.ResultSheet;
import lotto.view.InputParser;
import lotto.view.InputRetryHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final LottoUseCase lottoUseCase;


    public Controller(InputView inputView, LottoUseCase lottoUseCase) {
        this.inputView = inputView;
        this.lottoUseCase = lottoUseCase;
    }

    public void run() {
        PurchaseAmount purchaseAmount = askPurchaseAmount();

        LottoCart lottoCart = issueLottos(purchaseAmount);
        showIssuedLottos(lottoCart);

        WinningLotto winningLotto = askWinningLotto();
        ResultSheet resultSheet = lottoUseCase.compare(winningLotto, lottoCart);

        showStatistics(resultSheet, purchaseAmount);
    }

    private LottoCart issueLottos(PurchaseAmount purchaseAmount) {
        return lottoUseCase.generateLottoCart(purchaseAmount);
    }

    private void showIssuedLottos(LottoCart lottoCart) {
        OutputView.printLottoCount(lottoCart);
        OutputView.printLottoCart(lottoCart);
    }

    private WinningLotto askWinningLotto() {
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber();
        return createValidWinningLotto(winningNumbers, bonusNumber);
    }

    private void showStatistics(ResultSheet resultSheet, PurchaseAmount purchaseAmount) {
        double rateOfReturn = lottoUseCase.calculateRateOfReturn(resultSheet, purchaseAmount);

        OutputView.printWinningStatistics(resultSheet);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private PurchaseAmount askPurchaseAmount() {
        return InputRetryHandler.askUntilValid(() -> {
            String amountInput = InputParser.validateBlank(inputView.purChaseAmountReadLine());
            return new PurchaseAmount(InputParser.toInt(amountInput));
        });
    }

    private WinningNumbers getWinningNumbers() {
        return InputRetryHandler.askUntilValid(() -> {
            List<String> winningNumbersInput = InputParser.parseValidateNumbers(inputView.winningNumbersReadLine());
            return new WinningNumbers(InputParser.toInts(winningNumbersInput));
        });
    }

    private BonusNumber getBonusNumber() {
        return InputRetryHandler.askUntilValid(() -> {
            String bonusInput = InputParser.validateBlank(inputView.bonusNumberReadLine());
            return new BonusNumber(InputParser.toInt(bonusInput));
        });
    }

    private WinningLotto createValidWinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        while (true) {
            try {
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
                bonusNumber = getBonusNumber();
            }
        }
    }
}
