package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    @DisplayName("당첨번호 갯수에 맞게 Rank와 연결되는지 확인")
    void 당첨번호_갯수에_맞게_Rank와_연결되는지_확인() {
        등수_검증하기(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST);
        등수_검증하기(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND);
        등수_검증하기(List.of(1, 2, 3, 4, 5, 8), Rank.THIRD);
        등수_검증하기(List.of(1, 2, 3, 4, 8, 9), Rank.FOURTH);
        등수_검증하기(List.of(1, 2, 3, 8, 9, 10), Rank.FIFTH);
    }

    private void 등수_검증하기(List<Integer> numbers, Rank expectedRank) {
        LottoService service = new LottoService();
        WinningNumbers winning = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        Lottos lottos = new Lottos(List.of(new Lotto(numbers)));
        Map<Rank, Integer> result = service.calculateResult(lottos, winning, bonus);
        assertThat(result.get(expectedRank)).isEqualTo(1);

    }
}