package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
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

    public static void printWinningResult() {
        System.out.println(Messages.PRINT_WINNING_RESULT + "\n" + Messages.PRINT_BARS);
    }

    public static void printStatistics(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            int count = result.getOrDefault(rank, 0);
            StringBuilder sb = new StringBuilder();
            sb.append(rank.getMatchCount()).append("개 일치");
            if (rank.isMatchBonus()) {
                sb.append(", 보너스 볼 일치");
            }
            System.out.printf("%s (%,d원) - %d개\n", sb, rank.getWinningMoney(), count);
        }
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}
