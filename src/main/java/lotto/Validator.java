package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static int validatePurchaseAmount(String input) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_NOT_NUMBER);
        }
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 양수를 입력해야합니다.");
        }
        if ((purchaseAmount % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야합니다");
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
        int number;
        try {
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_NOT_NUMBER);
        }

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