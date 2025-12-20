package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        return new ArrayList<>(Integer.parseInt(Arrays.toString(input.split("[,]"))));
    }

    public static int bonusInput(List<Integer> winningNumbers) {
        String input = Console.readLine();
        Validator.validateIsEmpty(input);
        Validator.validateIsNotDigit(input);
        Validator.validateBonus(input, winningNumbers);
    }
}
