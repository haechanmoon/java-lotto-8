package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

public class Validator {
    private static final int PRICE_UNIT = 1000;

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
        if ((Integer.parseInt(input) % PRICE_UNIT) != 0 || Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(Messages.ERROR_IS_NOT_THOUSAND_UNIT);
        }
    }

    public static void validateNumberRange(int num) {
        validateNotDigit(String.valueOf(num));
        if (num < Lotto.MIN_NUMBER || num > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(Messages.ERROR_NUBER_RANGE);
        }
    }

    public static void validateBonusNumberDuplicated(WinningNumbers winningNumbers, int num) {
        if (winningNumbers.contains(num)) {
            throw new IllegalArgumentException(Messages.ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }

    public static void validateBonusNumber(WinningNumbers winningNumbers, int num) {
        validateNumberRange(num);
        validateBonusNumberDuplicated(winningNumbers, num);
    }

}