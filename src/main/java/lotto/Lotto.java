package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE_UNIT = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Messages.ERROR_LOTTO_NUMBER_COUNT);
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Messages.ERROR_LOTTO_NUMBER_DUPLICATE);
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(Messages.ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(this.numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        int matchCount = 0;
        for (int number : this.numbers) {
            if (winningLotto.containsNumber(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
