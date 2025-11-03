package lotto.domain;

public class PurchaseAmount {

    private final static int MONEY_UNIT = 1000;
    private final static String ERR_AMOUNT_UNIT = "구입 금액은 1,000단위만 가능합니다.";

    private final int amount;

    public PurchaseAmount(int amountInput) {
        validateUnit(amountInput);
        this.amount = amountInput;
    }

    private void validateUnit(int amount) {
        if (!is1000Unit(amount)) {
            throw new IllegalArgumentException(ERR_AMOUNT_UNIT);
        }
    }

    private boolean is1000Unit(int amount) {
        return amount % MONEY_UNIT == 0;
    }

    public int getAmount() {
        return amount;
    }

    public int calculateLottoCount() {
        return amount / MONEY_UNIT;
    }


}
