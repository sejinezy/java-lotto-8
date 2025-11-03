package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.port.PickRandomNumbers;
import lotto.infra.random.DefaultPickRandomValues;
import lotto.service.LottoGame;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PickRandomNumbers pickRandomNumbers = new DefaultPickRandomValues();
        LottoGenerator lottoGenerator = new LottoGenerator(pickRandomNumbers);
        LottoGame lottoGame = new LottoGame();
        LottoUseCase lottoUseCase = new LottoUseCase(lottoGenerator, lottoGame);
        Controller controller = new Controller(inputView, lottoUseCase);

        controller.run();
    }
}
