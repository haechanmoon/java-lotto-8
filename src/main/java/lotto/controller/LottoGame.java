package lotto.controller;

import java.util.List;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        OutputView.requestMoney();
        int money = InputView.moneyInput();

        LottoService service = new LottoService();
        int lottoCount = service.lottoCount(money);
        Lottos lottos = service.generateLottos(lottoCount);
        OutputView.printAllLottos(lottos);

        OutputView.requestWinningNumbers();
        List<Integer> winningNumbers = InputView.winningNumbersInput();
        int bonus = InputView.bonusInput();

    }
}
