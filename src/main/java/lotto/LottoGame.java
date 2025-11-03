package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        int amount = inputView.getPurchaseAmount();
        List<Lotto> purchasedLottos = createAndShowLottos(amount);

        Lotto winningLotto = new Lotto(inputView.getWinningNumbers());
        int bonusNumber = inputView.getBonusNumber(winningLotto.getSortedNumbers());

        Map<LottoRank, Integer> statistics = calculateStatistics(purchasedLottos, winningLotto, bonusNumber);

        printGameResult(statistics, amount);
    }

    private List<Lotto> createAndShowLottos(int amount) {
        int lottoCount = amount / 1000;
        outputView.printLottoCount(lottoCount);
        List<Lotto> purchasedLottos = generateLottos(lottoCount);
        outputView.printLottos(purchasedLottos);
        return purchasedLottos;
    }

    private Map<LottoRank, Integer> calculateStatistics(
            List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber
    ) {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean bonusMatch = lotto.containsNumber(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

    private void printGameResult(Map<LottoRank, Integer> statistics, int amount) {
        outputView.printWinningStatistics(statistics);
        long totalPrize = calculateTotalPrize(statistics);
        double yield = calculateYield(totalPrize, amount);
        outputView.printTotalYield(yield);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private long calculateTotalPrize(Map<LottoRank, Integer> statistics) {
        long totalPrize = 0;

        for (LottoRank rank : statistics.keySet()) {
            int prizeMoney = rank.getWinnings();
            int count = statistics.get(rank);
            totalPrize += (long) prizeMoney * count;
        }
        return totalPrize;
    }

    private double calculateYield(long totalPrize, int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return (double) totalPrize / purchaseAmount * 100.0;
    }
}