package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println(Messages.ASK_PURCHASE_AMOUNT);
                String input = Console.readLine();
                int purchaseAmount = Validator.validatePurchaseAmount(input);
                return purchaseAmount;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println(Messages.ASK_WINNING_NUMBER);
                String input = Console.readLine();

                List<Integer> winningNumbers = Validator.validateWinningNumbers(input);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}