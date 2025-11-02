package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 올바르게 오름차순 정렬되는지 테스트")
    void getSortedNumbersTest() {
        // given
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));

        // when
        List<Integer> sorted = lotto.getSortedNumbers();

        // then
        assertThat(sorted).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("일치하는 번호 개수 세기 테스트")
    void countMatchingNumbersTest() {
        // given
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        // when
        int matchCount = myLotto.countMatchingNumbers(winningLotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }
}
