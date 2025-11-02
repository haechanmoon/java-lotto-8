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

    @Test
    @DisplayName("5개 일치 + 보너스 일치 시 2등을 반환한다")
    void valueOf_5_matches_with_bonus() {
        // given
        int matchCount = 5;
        boolean bonusMatch = true;

        // when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        // then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
        assertThat(rank.getWinnings()).isEqualTo(30_000_000);
    }
}