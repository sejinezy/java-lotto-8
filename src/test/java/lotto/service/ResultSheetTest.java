package lotto.service;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Rank;
import lotto.domain.ResultSheet;
import org.junit.jupiter.api.Test;

class ResultSheetTest {

    @Test
    void rank에_해당하는_값이_증가한다() {
        ResultSheet resultSheet = new ResultSheet();
        resultSheet.increase(Rank.FIRST);
        resultSheet.increase(Rank.FIFTH);

        assertThat(resultSheet.getCounts().get(Rank.FIRST)).isEqualTo(1);
        assertThat(resultSheet.getCounts().get(Rank.SECOND)).isEqualTo(0);
        assertThat(resultSheet.getCounts().get(Rank.THIRD)).isEqualTo(0);
        assertThat(resultSheet.getCounts().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(resultSheet.getCounts().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 수익금을_계산한다() {
        ResultSheet resultSheet = new ResultSheet();
        resultSheet.increase(Rank.FIRST);
        resultSheet.increase(Rank.FIFTH);
        assertThat(resultSheet.calculateProceeds()).isEqualTo(Rank.FIRST.getPrice() + Rank.FIFTH.getPrice());
    }
}