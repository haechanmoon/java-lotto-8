package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        OutputView.printInputMoney();
        String input = InputView.getInputMoney();

        OutputView.printLottoCount(LottoService.lottoCount(input));
        LottoService service = new LottoService();
        Lottos lottos = service.purchaseLotto(input);
        OutputView.printLottos(lottos);

    }
}
