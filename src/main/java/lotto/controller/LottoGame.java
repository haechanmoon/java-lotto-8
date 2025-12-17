package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        OutputView.printInputMoney();
        String input = InputView.getInputMoney();

        LottoService service = new LottoService();
        OutputView.printLottoCount(service.lottoCount(input));

        Lottos lottos = service.purchaseLotto(input);
        OutputView.printLottos(lottos);

        OutputView.printWinningNumber();
        String winningNumbers = InputView.getWinningNumbers();
        WinningNumbers winNum = service.splitWinningNumbers(winningNumbers);

        OutputView.printBonusNumber();
        int bonusNumber = InputView.getBonusNumber();
        Validator.validateBonusNumber(winNum, bonusNumber);

        
    }
}
