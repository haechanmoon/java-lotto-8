package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.utils.Messages;

public class OutputView {

    public static void printInputMoney() {
        System.out.println(Messages.ASK_INPUT_MONEY);
    }

    public static void printLottoCount(int count) {
        System.out.println(count + Messages.PRINT_LOTTO_COUNT);
    }


    public static void printWinningNumber() {
        System.out.println(Messages.PRINT_WINNING_NUMBERS);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public static void printBonusNumber() {
        System.out.println(Messages.PRINT_BONUS_NUMBER);
    }
}
