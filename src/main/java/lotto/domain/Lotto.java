package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.utils.Messages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_SIZE_OVER);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> lottoNum = new HashSet<>(numbers);
        if (lottoNum.size() != numbers.size()) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_DUPLICATED);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
