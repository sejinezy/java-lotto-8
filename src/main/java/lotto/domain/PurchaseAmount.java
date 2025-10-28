package lotto.domain;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(String amountInput) {
        int amount = parseInteger(amountInput);
        validateUnit(amount);
        this.amount = amount;
    }

    private int parseInteger(String amountInput) {
        try {
            return Integer.parseInt(amountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 가능합니다.");
        }
    }

    private void validateUnit(int amount) {
        if (! is1000Unit(amount)) {
            throw new IllegalArgumentException("[ERROR] 1,000단위만 가능합니다.");
        }
    }
    private boolean is1000Unit(int amount) {
        return amount % 1000 == 0;
    }

    public int getAmount() {
        return amount;
    }


}
