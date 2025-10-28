package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCart;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class LottoGame {

    // 일치하는 숫자 몇 개 인지 계산
    public List<Integer> compare(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winning = winningNumbers.getWinningNumbers();

        List<Integer> tmp = new ArrayList<>(numbers);
        tmp.retainAll(winning);

        return tmp;
    }

    public ResultSheet game(LottoCart lottoCart, WinningNumbers winningNumbers,BonusNumber bonusNumber) {
        ResultSheet resultSheet = new ResultSheet();
        for (Lotto lotto : lottoCart.lottoCart()) {
            List<Integer> compare = compare(lotto, winningNumbers);
            calculateRank(compare, resultSheet,bonusNumber);
        }
        return resultSheet;
    }

    // 등수 계산
    public ResultSheet calculateRank(List<Integer> tmp, ResultSheet resultSheet, BonusNumber bonusNumber) {
        int size = tmp.size();
        Map<Rank, Integer> sheet = resultSheet.getResultSheet();
        if (size == Rank.FIRST.getNumberOfMatches()) {
            sheet.put(Rank.FIRST, sheet.get(Rank.FIRST) + 1);
        }

        // 5개 일치
        if (size == Rank.SECOND.getNumberOfMatches()) {
            // 보너스 볼 일치 여부 확인
            if (tmp.contains(bonusNumber.getBonus())) {
                sheet.put(Rank.THIRD, sheet.get(Rank.THIRD) + 1);
            } else {
                sheet.put(Rank.SECOND, sheet.get(Rank.SECOND) + 1);
            }

        }

        if (size == Rank.FOURTH.getNumberOfMatches()) {
            sheet.put(Rank.FOURTH, sheet.get(Rank.FOURTH) + 1);
        }

        if (size == Rank.FIFTH.getNumberOfMatches()) {
            sheet.put(Rank.FIFTH, sheet.get(Rank.FIFTH) + 1);
        }
        return resultSheet;
    }

    public double calculateRateOfReturn(ResultSheet resultSheet, PurchaseAmount purchaseAmount) {
        int amount = purchaseAmount.getAmount();
        Map<Rank, Integer> sheet = resultSheet.getResultSheet();
        int proceeds = 0;
        for (Entry<Rank, Integer> entry : sheet.entrySet()) {
            proceeds += entry.getKey().getPrice() * entry.getValue();
        }
        double rateOfReturn = ((double) proceeds / amount) * 100;

        return rateOfReturn;
    }


}
