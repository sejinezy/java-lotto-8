package lotto.domain;

import java.util.HashSet;

public record WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {

    private static final String ERR_NUMBERS_DUPLICATION = "중복된 값이 있습니다.";
    private static final int WINNING_LOTTO_SIZE = 7;

    public WinningLotto {
        validateNoOverlap(winningNumbers, bonusNumber);
    }

    private void validateNoOverlap(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (!isBonusDistinctFromWinningNumbers(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ERR_NUMBERS_DUPLICATION);
        }
    }

    private boolean isBonusDistinctFromWinningNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        HashSet<Integer> result = new HashSet<>();
        result.add(bonusNumber.getBonus());
        result.addAll(winningNumbers.getWinningNumbers());
        return result.size() == WINNING_LOTTO_SIZE;
    }

}
