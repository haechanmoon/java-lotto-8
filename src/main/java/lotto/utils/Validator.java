package lotto.utils;

import lotto.domain.WinningNumbers;

public class Validator {
    public static void validateNotDigit(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_DIGIT);
        }
    }

    public static void validateIsEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Messages.ERROR_IS_EMPTY);
        }
    }

    public static void validateMoneyNotThousandUnit(String input) {
        if ((Integer.parseInt(input) % 1000) != 0) {
            throw new IllegalArgumentException(Messages.ERROR_IS_NOT_THOUSAND_UNIT);
        }
    }

    public static void validateBonusNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(Messages.ERROR_WINNING_NUBER_RANGE);
        }
    }

    public static void validateBonusNumberDuplicated(WinningNumbers winningNumbers, int num) {
        if (winningNumbers.contains(num)) {
            throw new IllegalArgumentException(Messages.ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }

    public static void validateBonusNumber(WinningNumbers winningNumbers, int num) {
        validateBonusNumberDuplicated(winningNumbers, num);
        validateBonusNumberRange(num);
    }

}
