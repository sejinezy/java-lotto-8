package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 담첨_번호_일치_개수와_보너스_번호_일치_여부를_통해_Rank_를_반환한다() {
        Assertions.assertThat(Rank.findByNumberOfMatchesAndHasBonus(6, false)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(Rank.findByNumberOfMatchesAndHasBonus(5, true)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(Rank.findByNumberOfMatchesAndHasBonus(5, false)).isEqualTo(Rank.THIRD);
        Assertions.assertThat(Rank.findByNumberOfMatchesAndHasBonus(4, false)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(Rank.findByNumberOfMatchesAndHasBonus(3, false)).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(Rank.findByNumberOfMatchesAndHasBonus(2, false)).isEqualTo(null);
        Assertions.assertThat(Rank.findByNumberOfMatchesAndHasBonus(2, true)).isEqualTo(null);
    }

}