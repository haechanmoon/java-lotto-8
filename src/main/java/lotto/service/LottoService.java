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
import lotto.utils.Validator;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public int lottoCount(String input) {
        return Integer.parseInt(input) / LOTTO_PRICE;
    }

    public Lottos purchaseLotto(String input) {
        int count = lottoCount(input);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> random = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.SIZE);
            Lotto lotto = new Lotto(random);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public WinningNumbers splitWinningNumbers(String numbers) {
        String[] winningNumbers = numbers.split("[,]");
        List<Integer> winningIntNumbers = new ArrayList<>();
        for (String val : winningNumbers) {
            Validator.validateNotDigit(val);
            Validator.validateIsEmpty(val);
            winningIntNumbers.add(Integer.parseInt(val));
        }
        return new WinningNumbers(winningIntNumbers);
    }

    public Map<Rank, Integer> calculateResult(Lottos lottos, WinningNumbers winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = countMatchingNumbers(lotto, winningNumbers);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private int countMatchingNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public double calculateReturnRate(Map<Rank, Integer> result, int inputMoney) {
        double totalPrize = 0;
        for (Rank rank : result.keySet()) {
            totalPrize += rank.getWinningMoney() * result.get(rank);
        }
        return (totalPrize / inputMoney) * 100;
    }

}
