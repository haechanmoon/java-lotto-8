package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
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
