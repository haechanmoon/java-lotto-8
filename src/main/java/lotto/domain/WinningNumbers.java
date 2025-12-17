package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.utils.Messages;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        validateSize();
        validateRange();
        validateDuplicated();
    }


    private void validateSize() {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(Messages.ERROR_WINNING_NUMBERS_OVER_COUNT);
        }
    }

    private void validateRange() {
        for (Integer num : winningNumbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(Messages.ERROR_WINNING_NUBER_RANGE);
            }
        }
    }

    private void validateDuplicated() {
        HashSet<Integer> numbers = new HashSet<>(winningNumbers);
        if (numbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(Messages.ERROR_WINNING_NUMBER_DUPLICATED);
        }
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }


}
