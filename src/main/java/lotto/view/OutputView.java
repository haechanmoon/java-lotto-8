package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.utils.Messages;

public class OutputView {
    public static void requestMoney() {
        System.out.println(Messages.REQUEST_MONEY_INPUT);
    }

    public static void printAllLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
    }
}
