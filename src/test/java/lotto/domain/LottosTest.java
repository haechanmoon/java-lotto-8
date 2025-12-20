package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("Lottos객체는 Lotto List를 갖고있어야 한다.")
    @Test
    void Lotto_List_잘_갖고있는지_확인() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> lottoTest = List.of(lotto1, lotto2);

        //when
        Lottos lottos = new Lottos(lottoTest);

        //then
        assertThat(lottos.getLottos()).hasSize(2);
        assertThat(lottos.getLottos().get(0)).isEqualTo(lotto1);
    }
}