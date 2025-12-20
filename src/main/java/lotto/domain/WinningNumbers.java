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
        validateDuplicate();
    }

    private void validateSize() {
        if (winningNumbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(Messages.ERROR_WINNING_NUMBERS_OVER_COUNT);
        }
    }

    private void validateRange() {
        for (Integer num : winningNumbers) {
            if (num < Lotto.MIN_NUMBER || num > Lotto.MAX_NUMBER) {
                throw new IllegalArgumentException(Messages.ERROR_NUBER_RANGE);
            }
        }
    }

    private void validateDuplicate() {
        HashSet<Integer> numbers = new HashSet<>(winningNumbers);
        if (numbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(Messages.ERROR_WINNING_NUMBER_DUPLICATED);
        }
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

}
