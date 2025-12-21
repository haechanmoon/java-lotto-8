package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.utils.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoSize(numbers);
        Validator.validateLottoNotDuplicated(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }

    public int matchCount(List<Integer> winNum) {
        int match = 0;
        for (Integer num : numbers) {
            if (winNum.contains(num)) {
                match++;
            }
        }
        return match;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean matchBonus(int num) {
        return numbers.contains(num);
    }

}
