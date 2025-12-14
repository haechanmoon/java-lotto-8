package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {

    public static String getInputMoney() {
        String input = Console.readLine();
        Validator.validateInputEmpty(input);
        Validator.validateMoneyNotDigit(input);
        Validator.validateMoneyNotThousandUnit(input);
        return input;

    }
}
