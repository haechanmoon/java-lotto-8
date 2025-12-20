package lotto.utils;

public class Validator {

    public static void validateIsEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Messages.ERROR_IS_EMPTY);
        }
    }

    public static void validateIsNotDigit(String input) {
        if (input.matches("\\d+")) {
            throw new IllegalArgumentException(Messages.ERROR_IS_NOT_DIGIT);
        }
    }

    public static void validateMoney(String input) {
        int money = Integer.parseInt(input);
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException(Messages.ERROR_IS_NOT_UNIT);
        }

    }

}
