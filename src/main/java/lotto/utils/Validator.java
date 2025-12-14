package lotto.utils;

public class Validator {
    public static void validateMoneyNotDigit(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_DIGIT);
        }
    }

    public static void validateInputEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Messages.ERROR_IS_EMPTY);
        }
    }

}
