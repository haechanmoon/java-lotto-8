package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {

    public static String getInputMoney() {
        String input = Console.readLine();
        Validator.validateIsEmpty(input);
        Validator.validateNotDigit(input);
        Validator.validateMoneyNotThousandUnit(input);
        return input;
    }

    public static String getInputWinningNumbers() {
        return Console.readLine();
    }
}
