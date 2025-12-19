package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
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

    @Test
    @DisplayName("8,000원을 투자해서 5,000원(5등) 1개가 당첨되면 수익률은 62.5%가 나와야 한다.")
    void 수익률이_정확히_나오는지_확인() {
        //given
        LottoService service = new LottoService();
        int inputMoney = 8000;
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIFTH, 1);

        //when
        double returnRate = service.calculateReturnRate(result, inputMoney);

        //then
        assertThat(returnRate).isEqualTo(62.5);
    }

    @Test
    @DisplayName("아무것도 당첨되지 않았을 때 수익률은 0.0%여야 한다.")
    void 수익률_정확히_나오는지_확인_당첨없음() {
        //given
        LottoService service = new LottoService();
        int inputMoney = 5000;

        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.MISS, 5);

        //when
        double returnRate = service.calculateReturnRate(result, inputMoney);

        //then
        assertThat(returnRate).isEqualTo(0.0);
    }
}