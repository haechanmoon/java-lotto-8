package lotto.utils;

import java.util.HashSet;
import java.util.List;

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
        if (money == 0) {
            throw new IllegalArgumentException(Messages.ERROR_IS_ZERO);
        }
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_CORRECT_SIZE);
        }
    }

    public static void validateLottoNotDuplicated(List<Integer> numbers) {
        HashSet<Integer> lotto = new HashSet<>(numbers);
        if (lotto.size() != numbers.size()) {
            throw new IllegalArgumentException(Messages.ERROR_NUM_DUPLICATED);
        }
    }

}
