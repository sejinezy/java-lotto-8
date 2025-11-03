package lotto.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultSheetTest {

    @Test
    void rank에_해당하는_값이_증가한다() {
        ResultSheet resultSheet = new ResultSheet();
        resultSheet.increase(Rank.FIRST);
        resultSheet.increase(Rank.FIFTH);

        assertThat(resultSheet.getResultSheet().get(Rank.FIRST)).isEqualTo(1);
        assertThat(resultSheet.getResultSheet().get(Rank.SECOND)).isEqualTo(0);
        assertThat(resultSheet.getResultSheet().get(Rank.THIRD)).isEqualTo(0);
        assertThat(resultSheet.getResultSheet().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(resultSheet.getResultSheet().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 수익금을_계산한다() {
        ResultSheet resultSheet = new ResultSheet();
        resultSheet.increase(Rank.FIRST);
        resultSheet.increase(Rank.FIFTH);
        assertThat(resultSheet.calculateProceeds()).isEqualTo(Rank.FIRST.getPrice() + Rank.FIFTH.getPrice());
    }
}