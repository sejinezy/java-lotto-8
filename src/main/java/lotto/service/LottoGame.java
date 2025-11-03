package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCart;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.ResultSheet;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;

public class LottoGame {

    public ResultSheet compare(WinningLotto winningLotto, LottoCart lottoCart) {
        ResultSheet resultSheet = new ResultSheet();
        for (Lotto lotto : lottoCart.lottoCart()) {
            int numberOfMatches = compare(lotto, winningLotto.winningNumbers());
            boolean hasBonus = lotto.contains(winningLotto.bonusNumber());
            Rank myRank = calculateRank(numberOfMatches, hasBonus);
            if (myRank == null) {
                continue;
            }
            resultSheet.increase(myRank);
        }
        return resultSheet;
    }

    private int compare(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> numbers = lotto.numbers();
        List<Integer> winning = winningNumbers.getWinningNumbers();

        List<Integer> tmp = new ArrayList<>(numbers);
        tmp.retainAll(winning);

        return tmp.size();
    }

    private Rank calculateRank(int count, boolean hasBonus) {
        return Rank.findByNumberOfMatchesAndHasBonus(count, hasBonus);
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount, ResultSheet resultSheet) {
        int amount = purchaseAmount.getAmount();
        int proceeds = resultSheet.calculateProceeds();
        return ((double) proceeds / amount) * 100;
    }
}
