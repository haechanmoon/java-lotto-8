package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.utils.Validator;

public class LottoService {

    public int lottoCount(String input) {
        return Integer.parseInt(input) / 1000;
    }

    public Lottos purchaseLotto(String input) {
        int count = lottoCount(input);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> random = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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


}
