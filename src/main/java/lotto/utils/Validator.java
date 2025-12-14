package lotto.utils;

public class Validator {
    public static void validateMoneyNotDigit(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_DIGIT);
        }
    }

}
