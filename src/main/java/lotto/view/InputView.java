package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {
    public static int moneyInput() {
        String input = Console.readLine();
        Validator.validateIsEmpty(input);
        Validator.validateIsNotDigit(input);
        Validator.validateMoney(input);
        return Integer.parseInt(input);
    }
}
