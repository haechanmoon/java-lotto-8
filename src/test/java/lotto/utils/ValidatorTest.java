package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.WinningNumbers;
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
    @ValueSource(strings = {"900", "1500", "3"})
    @DisplayName("구입금액이 1000단위가 아닌 숫자일 때 예외처리 확인")
    void 구입금액이_1000단위가_아닌_숫자일_때(String input) {
        assertThatThrownBy(() -> Validator.validateMoneyNotThousandUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_IS_NOT_THOUSAND_UNIT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "55"})
    @DisplayName("보너스번호 범위가 1-45를 벗어났을 때 예외처리 확인")
    void 보너스번호_범위를_벗어낫을_때(int num) {
        assertThatThrownBy(() -> Validator.validateBonusNumberRange(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_WINNING_NUBER_RANGE);
    }

    @Test
    @DisplayName("보너스번호가 당첨번호랑 중복됐을 때 예외처리 확인")
    void 보너스번호가_당첨번호랑_중복됐을_때() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winNum = new WinningNumbers(winningNumber);
        int bonusNumber = 4;

        assertThatThrownBy(() -> Validator.validateBonusNumberDuplicated(winNum, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ERROR_BONUS_NUMBER_DUPLICATED);
    }

}