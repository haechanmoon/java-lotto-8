package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_NOT_NUMBER);
        }
    }

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = parseInt(input);
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(Messages.ERROR_PURCHASE_AMOUNT_NOT_POSITIVE);
        }
        if ((purchaseAmount % 1000) != 0) {
            throw new IllegalArgumentException(Messages.ERROR_PURCHASE_AMOUNT_NOT_IN_UNITS);
        }
        return purchaseAmount;
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        if (numberStrings.length != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(Messages.ERROR_WINNING_NUMBER_COUNT);
        }
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String numberStr : numberStrings) {
            int number = validateNumberString(numberStr);
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(Messages.ERROR_WINNING_NUMBER_DUPLICATE);
            }
            numbers.add(number);
        }
        return numbers;
    }

    public static int validateNumberString(String numberStr) {
        int number = parseInt(numberStr);
        Lotto.validateNumberRange(number);
        return number;
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = validateNumberString(input);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Messages.ERROR_BONUS_NUMBER_DUPLICATE);
        }
        return bonusNumber;
    }
}