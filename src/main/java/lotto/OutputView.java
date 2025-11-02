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
        System.out.print("\n");
    }

    public void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf(
                "%s (%s원) - %d개%n",
                LottoRank.FIFTH.getDescription(),
                LottoRank.FIFTH.getFormattedPrizeMoney(),
                statistics.get(LottoRank.FIFTH)
        );
        System.out.printf(
                "%s (%s원) - %d개%n",
                LottoRank.FOURTH.getDescription(),
                LottoRank.FOURTH.getFormattedPrizeMoney(),
                statistics.get(LottoRank.FOURTH)
        );
        System.out.printf(
                "%s (%s원) - %d개%n",
                LottoRank.THIRD.getDescription(),
                LottoRank.THIRD.getFormattedPrizeMoney(),
                statistics.get(LottoRank.THIRD)
        );
        System.out.printf(
                "%s (%s원) - %d개%n",
                LottoRank.SECOND.getDescription(),
                LottoRank.SECOND.getFormattedPrizeMoney(),
                statistics.get(LottoRank.SECOND)
        );
        System.out.printf(
                "%s (%s원) - %d개%n",
                LottoRank.FIRST.getDescription(),
                LottoRank.FIRST.getFormattedPrizeMoney(),
                statistics.get(LottoRank.FIRST)
        );
    }
}