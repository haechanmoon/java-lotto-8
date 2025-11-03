package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @DisplayName("일치 개수와 보너스 여부에 따라 올바른 등수를 반환한다")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true,  SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS",
            "1, true,  MISS"
    })
    void 등수_판별_테스트(int matchCount, boolean bonusMatch, LottoRank expectedRank) {
        // given & when
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

        // then
        assertThat(rank).isEqualTo(expectedRank);
    }

    @DisplayName("일치 개수와 보너스 여부에 따라 올바른 상금을 반환한다")
    @ParameterizedTest
    @CsvSource({
            "6, false, 2000000000",
            "5, true,  30000000",
            "5, false, 1500000",
            "4, false, 50000",
            "3, false, 5000"
    })
    void 상금_테스트(int matchCount, boolean bonusMatch, int expectedWinnings) {
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
        assertThat(rank.getWinnings()).isEqualTo(expectedWinnings);
    }
}