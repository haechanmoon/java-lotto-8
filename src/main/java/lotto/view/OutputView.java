package lotto.view;

import lotto.utils.Messages;

public class OutputView {

    public static void printInputMoney() {
        System.out.println(Messages.ASK_INPUT_MONEY);
    }

    public static void printLottoCount(int count) {
        System.out.println(count + Messages.PRINT_LOTTO_COUNT);
    }


}
