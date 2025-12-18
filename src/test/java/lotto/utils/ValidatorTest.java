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

    @ParameterizedTest
    @ValueSource(strings = {"900", "1500", "10o0"})
    @DisplayName("구입금액이 1000단위가 아닌 숫자일 때 예외처리 확인")
    void 구입금액이_1000단위가_아닌_숫자일_때(String input) {
        assertThatThrownBy(() -> Validator.validateMoneyNotThousandUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_IS_NOT_THOUSAND_UNIT);
    }

    
}