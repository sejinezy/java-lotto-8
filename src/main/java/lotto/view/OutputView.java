package lotto.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
    public static final String PREFIX_ERROR_MESSAGE = "[ERROR] ";

    private OutputView() {
    }

    public static void printLottoCount(LottoCart lottoCart) {
        System.out.printf(PRINT_LOTTO_CART_MESSAGE, lottoCart.lottoCart().size());
    }

    public static void printLottoCart(LottoCart lottoCart) {
        for (Lotto lotto : lottoCart.lottoCart()) {
            List<Integer> numbers = new ArrayList<>(lotto.numbers());
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
        }
    }

    public static void printWinningStatistics(ResultSheet resultSheet) {
        System.out.println();
        System.out.printf(WINNING_STATISTICS_MESSAGE);

        for (Rank rank : Rank.values()) {
            int count = resultSheet.getCount(rank);
            System.out.printf(getMessageBy(rank), rank.getNumberOfMatches(), rank.getPrice(), count);
        }
    }

    private static String getMessageBy(Rank rank) {
        if (rank.hasBonus()) {
            return RESULT_SHEET_HAS_BONUS_MESSAGE;
        }
        return RESULT_SHEET_DONT_HAVE_MESSAGE;
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(PRINT_RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public static void printError(String errorMessage) {
        System.out.println(PREFIX_ERROR_MESSAGE + errorMessage);
    }
}
