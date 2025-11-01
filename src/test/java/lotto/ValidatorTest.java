package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외 발생 후 재입력 해야한다.")
    void 구입_금액이_1000_단위가_아닐_때(){
        //given
        int purchaseAmount = 1500;

        //when&then
        assertThatThrownBy(()-> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}