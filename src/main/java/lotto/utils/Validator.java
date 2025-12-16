package lotto.utils;

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


}
