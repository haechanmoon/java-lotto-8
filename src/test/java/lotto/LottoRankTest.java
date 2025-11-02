package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("6개 일치 시 1등을 반환한다")
    void 여섯개_일치_시_1등을_반환() {
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
    void 다섯개_일치와_보너스_일치_시_2등을_반환() {
        // given
        int matchCount = 5;
        boolean bonusMatch = true;

        // when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        // then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
        assertThat(rank.getWinnings()).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName("5개 일치 + 보너스 불일치 시 3등을 반환한다")
    void 다섯개_일치와_보너스_불일치_시_3등을_반환() {
        // given
        int matchCount = 5;
        boolean bonusMatch = false;

        // when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        // then
        assertThat(rank).isEqualTo(LottoRank.THIRD);
        assertThat(rank.getWinnings()).isEqualTo(1_500_000);
    }

    @Test
    @DisplayName("4개 일치 시 4등을 반환한다")
    void 네개_일치_시_4등을_반환() {
        // given
        int matchCount = 4;
        boolean bonusMatch = false;

        // when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        // then
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
        assertThat(rank.getWinnings()).isEqualTo(50_000);
    }
}