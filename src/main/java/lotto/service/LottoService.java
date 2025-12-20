package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int COUNT = 6;

    public int lottoCount(int money) {
        return money / 1000;
    }

    private List<Integer> putRandom() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, COUNT);
    }

    private Lotto generateLotto() {
        List<Integer> random = putRandom();
        return new Lotto(random);
    }

    public Lottos generateLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount(money); i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }


}
