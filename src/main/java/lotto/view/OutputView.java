package lotto.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoCart;
import lotto.domain.Rank;
import lotto.domain.ResultSheet;

public class OutputView {

    public static final String PRINT_LOTTO_CART_MESSAGE = "%n%d개를 구매했습니다.%n";
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계%n---%n";
    public static final String RESULT_SHEET_HAS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    public static final String RESULT_SHEET_DONT_HAVE_MESSAGE = "%d개 일치 (%,d원) - %d개%n";
    public static final String PRINT_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    public void printLottoCount(LottoCart lottoCart) {
        System.out.printf(PRINT_LOTTO_CART_MESSAGE, lottoCart.lottoCart().size());
    }

    public void printLottoCart(LottoCart lottoCart) {
        for (Lotto lotto : lottoCart.lottoCart()) {
            List<Integer> numbers = new ArrayList<>(lotto.numbers());
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
        }
    }

    public void printWinningStatistics(ResultSheet resultSheet) {
        System.out.println();
        System.out.printf(WINNING_STATISTICS_MESSAGE);

        for (Entry<Rank, Integer> entry : resultSheet.getResultSheet().entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();

            System.out.printf(getMessageBy(rank), rank.getNumberOfMatches(), rank.getPrice(), count);
        }
    }

    private String getMessageBy(Rank rank) {
        if (rank == Rank.SECOND) {
            return RESULT_SHEET_HAS_BONUS_MESSAGE;
        }
        return RESULT_SHEET_DONT_HAVE_MESSAGE;
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(PRINT_RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
