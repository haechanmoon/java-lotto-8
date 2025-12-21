package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningNumbers;
import lotto.utils.Validator;

public class InputView {
    public static int moneyInput() {
        String input = Console.readLine();
        Validator.validateIsEmpty(input);
        Validator.validateIsNotDigit(input);
        Validator.validateMoney(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> winningNumbersInput() {
        String input = Console.readLine();
        String[] numbers = input.split("[,]");
        List<Integer> nums = new ArrayList<>();
        for (String num : numbers) {
            nums.add(Integer.parseInt(num));
        }
        return nums;
    }

    public static int bonusInput(WinningNumbers winningNumbers) {
        String input = Console.readLine();
        Validator.validateIsEmpty(input);
        Validator.validateIsNotDigit(input);
        Validator.validateBonus(input, winningNumbers);
        return Integer.parseInt(input);
    }
}
