package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        OutputView.requestMoney();
        int money = InputView.moneyInput();

        LottoService service = new LottoService();
        int lottoCount = service.lottoCount(money);
    }
}
