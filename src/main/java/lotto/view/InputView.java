package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.%n";
    private static final String INPUT_WINNING_NUMBERS = "%n당첨 번호를 입력해 주세요.%n";
    private static final String INPUT_BONUS_NUMBER = "%n보너스 번호를 입력해 주세요.%n";

    public String purChaseAmountReadLine() {
        System.out.printf(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String winningNumbersReadLine() {
        System.out.printf(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String bonusNumberReadLine() {
        System.out.printf(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
