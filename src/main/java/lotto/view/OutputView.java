package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
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

    public static void requestWinningNumbers() {
        System.out.println(Messages.REQUEST_WINNING_NUMBERS_INPUT);
    }

    public static void printBeforeResult() {
        System.out.println(Messages.PRINT_BEFORE_RESULT);
    }

    public static void printResult(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            int count = result.getOrDefault(rank, 0);
            StringBuilder sb = new StringBuilder();
            sb.append(rank.getMatchCount()).append("개 일치");
            if (rank == Rank.SECOND) {
                sb.append(", 보너스 볼 일치");
            }
            System.out.printf("%s (%,d) - %d개%n", sb, rank.getWinningMoney(), count);
        }
    }

    public static void requestBonusNumber() {
        System.out.println(Messages.REQUEST_BONUS_NUMBER);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + Messages.PRINT_LOTTO_COUNT);
    }

    public static void printRatio(double ratio) {
        System.out.printf("총 수익률은 %.1f%%입니다", ratio);
    }
}
