package lotto;

import java.util.List;

public class OutputView {

    public void printLottoCount(int count) {
        System.out.println("\n" + count + Messages.VIEW_PURCHASE_TOTAL_LOTTO);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
        System.out.print("\n");
    }
}