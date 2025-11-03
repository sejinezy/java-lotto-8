package lotto.domain;

import java.util.List;
import lotto.domain.validator.Validator;

public record Lotto(List<Integer> numbers) {

    public Lotto {
        Validator.size(numbers);
        Validator.duplication(numbers);
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonus());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
