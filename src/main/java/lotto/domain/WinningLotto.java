package lotto.domain;

import java.util.HashSet;

public record WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {

    private static final String ERR_NUMBERS_DUPLICATION = "[ERROR] 중복된 값이 있습니다.";
    private static final int WINNING_LOTTO_SIZE = 7;

    public WinningLotto {
        validateDuplication(winningNumbers, bonusNumber);
    }

    private void validateDuplication(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (!isUnique(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ERR_NUMBERS_DUPLICATION);
        }
    }

    private boolean isUnique(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        HashSet<Integer> result = new HashSet<>();
        result.add(bonusNumber.getBonus());
        result.addAll(winningNumbers.getWinningNumbers());
        return result.size() == WINNING_LOTTO_SIZE;
    }

}
