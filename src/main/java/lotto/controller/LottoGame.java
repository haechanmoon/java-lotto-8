package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
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
        WinningNumbers winning = new WinningNumbers(InputView.winningNumbersInput());
        int bonus = InputView.bonusInput(winning.getWinningNumbers());
    }
}
