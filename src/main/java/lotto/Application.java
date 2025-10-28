package lotto;

import lotto.domain.port.PickRandomNumbers;
import lotto.infra.random.DefaultPickRandomValues;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PickRandomNumbers pickRandomNumbers = new DefaultPickRandomValues();
        OutputView outputView = new OutputView();

        Controller controller = new Controller(inputView, pickRandomNumbers, outputView);

        while (true) {
            try {
                controller.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
