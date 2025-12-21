package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public boolean isContainBonus(int bonus) {
        return winningNumbers.contains(bonus);
    }

    public boolean isContains(Integer num) {
        return winningNumbers.contains(num);
    }

}
