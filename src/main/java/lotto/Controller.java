package lotto;

import static lotto.view.InputParser.*;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoCart;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import lotto.domain.ResultSheet;
import lotto.view.InputRetryHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final LottoUseCase lottoUseCase;
    private final OutputView outputView;

    public Controller(InputView inputView, LottoUseCase lottoUseCase, OutputView outputView) {
        this.inputView = inputView;
        this.lottoUseCase = lottoUseCase;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();

        LottoCart lottoCart = lottoUseCase.generateLottoCart(purchaseAmount);
        outputView.printLottoCount(lottoCart);
        outputView.printLottoCart(lottoCart);

        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber();
        WinningLotto winningLotto = validWinningLotto(winningNumbers, bonusNumber);

        ResultSheet resultSheet = lottoUseCase.compare(winningLotto, lottoCart);
        double rateOfReturn = lottoUseCase.calculateRateOfReturn(winningLotto, lottoCart, purchaseAmount);

        outputView.printWinningStatistics(resultSheet);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private BonusNumber getBonusNumber() {
        return InputRetryHandler.askUtilValid(() -> {
            String bonusInput = validateBlank(inputView.bonusNumberReadLine());
            return new BonusNumber(changeType(bonusInput));
        });
    }

    private WinningNumbers getWinningNumbers() {
        return InputRetryHandler.askUtilValid(() -> {
            List<String> winningNumbersInput = parseValidateNumbers(inputView.winningNumbersReadLine());
            return new WinningNumbers(changeType(winningNumbersInput));
        });
    }

    private PurchaseAmount getPurchaseAmount() {
        return InputRetryHandler.askUtilValid(() -> {
            String amountInput = validateBlank(inputView.purChaseAmountReadLine());
            return new PurchaseAmount(changeType(amountInput));
        });
    }

    private WinningLotto validWinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        while (true) {
            try {
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bonusNumber = getBonusNumber();
            }
        }
    }
}
