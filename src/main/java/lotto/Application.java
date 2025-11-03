package lotto;

import lotto.domain.port.PickRandomNumbers;
import lotto.infra.random.DefaultPickRandomValues;
import lotto.service.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        PickRandomNumbers pickRandomNumbers = new DefaultPickRandomValues();
        LottoGame lottoGame = new LottoGame();

        LottoUseCase lottoUseCase = new LottoUseCase(pickRandomNumbers, lottoGame);

        Controller controller = new Controller(inputView, lottoUseCase, outputView);
        controller.run();

    }
}
