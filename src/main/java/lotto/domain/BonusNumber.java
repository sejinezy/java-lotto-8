package lotto.domain;

import java.util.List;

public class BonusNumber {

    private static final String ERR_NUMBER_RANGE = "[ERROR] 1 ~ 45 사이의 숫자만 가능합니다.";
    private static final String ERR_DUPLICATE_BONUS = "[ERROR] 보너스 번호는 당첨 숫자와 중복될 수 없습니다.";

    private final int bonus;

    public BonusNumber(String bonusInput, WinningNumbers winningNumbers) {
        int bonus = parseInteger(bonusInput);
        validateRange(bonus);
        validateUniqueNumber(winningNumbers);
        this.bonus = bonus;
    }

    private int parseInteger(String bonusInput) {
        try {
            return Integer.parseInt(bonusInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
    }

    private void validateRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERR_NUMBER_RANGE);
        }
    }

    private void validateUniqueNumber(WinningNumbers winningNumbers) {
        List<Integer> winning = winningNumbers.getWinningNumbers();
        if (winning.contains(bonus)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_BONUS);
        }
    }

    public int getBonus() {
        return bonus;
    }
}
