package lotto;

public class Validator {
    public static int validatePurchaseAmount(String input) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 양수를 입력해야합니다.");
        }
        if ((purchaseAmount % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야합니다");
        }
        return purchaseAmount;
    }


}