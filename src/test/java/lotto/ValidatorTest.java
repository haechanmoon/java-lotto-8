package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    void 구입_금액이_1000_단위가_아닐_때() {
        //given
        String purchaseAmount = "1500";

        //when&then
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    void 구입_금액이_숫자가_아닐_때() {
        //given
        String purchaseAmount = "abc";

        //when&then
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 0 이하의 정수일 경우 예외가 발생한다.")
    void 구입_금액이_0이하의_정수일때() {
        //given
        String purchaseAmount = "-2000";

        //when&then
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 1~45 범위 밖의 숫자가 있으면 예외 발생")
    void 당첨_번호에_범위_밖_숫자가_있을_때() {
        // given
        String input = "1,2,3,4,5,46";

        // when & then
        assertThatThrownBy(() -> Validator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}