package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("6개 일치 시 1등을 반환한다")
    void valueOf_6_matches() {
        // given
        int matchCount = 6;
        boolean bonusMatch = false;

        // when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        // then
        assertThat(rank).isEqualTo(LottoRank.FIRST);
        assertThat(rank.getWinnings()).isEqualTo(2_000_000_000);
    }
}