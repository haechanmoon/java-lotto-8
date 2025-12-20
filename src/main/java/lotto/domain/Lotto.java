package lotto.domain;

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
        return numbers.toString();
    }


}
