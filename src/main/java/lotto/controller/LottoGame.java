package lotto.controller;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Rank;
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
        OutputView.printLottoCount(lottoCount);
        OutputView.printAllLottos(lottos);

        OutputView.requestWinningNumbers();
        WinningNumbers winning = new WinningNumbers(InputView.winningNumbersInput());
        OutputView.requestBonusNumber();
        int bonus = InputView.bonusInput(winning);

        Map<Rank, Integer> result = service.calculate(lottos, winning, bonus);
        OutputView.printBeforeResult();
        OutputView.printResult(result);
        double ratio = service.calculateRate(result, money);
        OutputView.printRatio(ratio);
    }
}
