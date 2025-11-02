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

    public int getBonusNumber(List<Integer> winningNumbers) {
        System.out.print("\n");
        while (true) {
            try {
                System.out.println(Messages.ASK_BONUS_NUMBER);
                String input = Console.readLine();

                int bonusNumber = Validator.validateBonusNumber(input, winningNumbers);

                return bonusNumber;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // (5) 실패 시 재시도!
            }
        }
    }
}