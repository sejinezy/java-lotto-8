package lotto.view;

import java.util.function.Supplier;

public class InputRetryHandler {

    private InputRetryHandler() {
    }

    public static <T> T askUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
