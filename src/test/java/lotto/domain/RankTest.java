package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @DisplayName("맞춘 개수와 보너스 일치 여부에 따라 등수가 올바르게 반영되어야 한다.")
    @ParameterizedTest
    @CsvSource({
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,false,FOURTH",
            "3,false,FIFTH",
            "2,false,MISS",
            "0,false,MISS"
    })
    void 맞춘개수와_일치여부_비교(int countOfMatch, boolean matchBonus, Rank expectedRank) {
        //given&when
        Rank result = Rank.valueOf(countOfMatch, matchBonus);

        //then
        assertThat(result).isEqualTo(expectedRank);
    }


}