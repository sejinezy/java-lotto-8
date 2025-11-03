package lotto.domain;

import lotto.domain.validator.Validator;

public class BonusNumber {

    private final int bonus;

    public BonusNumber(int bonusInput) {
        Validator.range(bonusInput);
        this.bonus = bonusInput;
    }

    public int getBonus() {
        return bonus;
    }
}
