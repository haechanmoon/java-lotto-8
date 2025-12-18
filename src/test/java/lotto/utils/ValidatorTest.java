package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    @DisplayName("입력값이 빈칸일 때 예외처리 확인")
    void 입력값이_빈칸일_때() {
        String input = "";

        assertThatThrownBy(() -> Validator.validateIsEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_IS_EMPTY);
    }

    
}