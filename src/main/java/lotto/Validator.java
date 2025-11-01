package lotto;

public class Validator {
    public static void validatePurchaseAmount(int purchaseAmount) {
        if ((purchaseAmount%1000)!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야합니다");
        }
    }
}
