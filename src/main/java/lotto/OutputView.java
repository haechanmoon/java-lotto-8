package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoCount(int count) {
        System.out.println("\n" + count + Messages.VIEW_PURCHASE_TOTAL_LOTTO);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

    public void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.getPrintableRanks()) {
            System.out.printf(
                    "%s (%s원) - %d개%n",
                    rank.getDescription(),
                    rank.getFormattedWinnings(),
                    statistics.get(rank)
            );
        }
    }

    public void printTotalYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}