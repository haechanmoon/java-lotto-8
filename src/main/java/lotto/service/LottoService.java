package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

public class LottoService {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int COUNT = 6;
    private static final int PURCHASE_UNIT = 1000;

    public int lottoCount(int money) {
        return money / PURCHASE_UNIT;
    }

    private List<Integer> putRandom() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, COUNT);
    }

    private Lotto generateLotto() {
        List<Integer> random = putRandom();
        return new Lotto(random);
    }

    public Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    public Map<Rank, Integer> calculate(Lottos lottos, WinningNumbers winNum, int bonusNum) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = countingMatchNumbers(lotto, winNum);
            boolean matchBonus = lotto.matchBonus(bonusNum);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private int countingMatchNumbers(Lotto lotto, WinningNumbers winNum) {
        int count = 0;
        for (Integer num : lotto.getNumbers()) {
            if (winNum.isContains(num)) {
                count++;
            }
        }
        return count;
    }

    public double calculateRate(Map<Rank, Integer> result, int money) {
        double total = 0;
        for (Rank rank : result.keySet()) {
            total += rank.getWinningMoney() * result.get(rank);
        }
        return total / money * 100;
    }
}
