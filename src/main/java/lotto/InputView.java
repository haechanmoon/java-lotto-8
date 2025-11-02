package lotto;

import camp.nextstep.edu.missionutils.Console;

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
}