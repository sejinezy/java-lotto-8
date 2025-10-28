package lotto.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoCart;
import lotto.service.Rank;
import lotto.service.ResultSheet;

public class OutputView {

    public void printLottoCount(LottoCart lottoCart) {
        System.out.println();
        System.out.println(lottoCart.lottoCart().size() + "개를 구매했습니다.");
    }

    public void printLottoCart(LottoCart lottoCart) {
        for (Lotto lotto : lottoCart.lottoCart()) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
        }
    }

    public void printWinningStatistics(ResultSheet resultSheet) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Entry<Rank, Integer> entry : resultSheet.getResultSheet().entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            String commaNum = String.format("%,d", rank.getPrice());

            if(rank == Rank.SECOND){
                System.out.println(rank.getNumberOfMatches() + "개 일치, 보너스 볼 일치 (" + commaNum + "원) - " + count + "개");
            } else {
                System.out.println(rank.getNumberOfMatches() + "개 일치 (" + commaNum + "원) - " + count + "개");
            }

        }

    }

    public void printRateOfReturn(double rateOfReturn) {

        System.out.println("총 수익률은 " + String.format("%.1f",rateOfReturn) + "%입니다.");
    }
}
