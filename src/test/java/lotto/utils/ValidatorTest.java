package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @Test
    @DisplayName("입력값이 빈칸일 때 예외처리 확인")
    void 입력값이_빈칸일_때() {
        String input = "";

        assertThatThrownBy(() -> Validator.validateIsEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_IS_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa", "1b", "2o"})
    @DisplayName("입력값이 숫자가 아닐 때 예외처리 확인")
    void 입력값이_숫자가_아닐_때(String input) {
        assertThatThrownBy(() -> Validator.validateNotDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_NOT_DIGIT);
    }


}