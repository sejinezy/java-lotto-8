package lotto.view;

import java.util.function.Supplier;

public class InputRetryHandler {

    public static <T> T askUtilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
