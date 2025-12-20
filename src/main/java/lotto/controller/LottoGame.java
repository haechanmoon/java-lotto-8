package lotto.controller;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        LottoService service = new LottoService();

        String input = readInputMoney();
        Lottos lottos = purchaseLottos(service, input);

        WinningNumbers winNum = readWinningNumbers(service);
        int bonusNumber = readBonusNumber(winNum);

        displayResult(service, lottos, winNum, bonusNumber, input);
    }

    private Lottos purchaseLottos(LottoService service, String input) {
        OutputView.printLottoCount(service.lottoCount(input));
        Lottos lottos = service.purchaseLotto(input);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private void displayResult(LottoService service, Lottos lottos, WinningNumbers winNum, int bonusNumber,
            String input) {
        OutputView.printWinningResult();
        Map<Rank, Integer> result = service.calculateResult(lottos, winNum, bonusNumber);
        OutputView.printStatistics(result);
        double returnRate = service.calculateReturnRate(result, Integer.parseInt(input));
        OutputView.printReturnRate(returnRate);
    }

    private String readInputMoney() {
        while (true) {
            try {
                OutputView.printInputMoney();
                return InputView.getInputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers readWinningNumbers(LottoService service) {
        while (true) {
            try {
                OutputView.printWinningNumber();
                String input = InputView.getWinningNumbers();
                return service.splitWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readBonusNumber(WinningNumbers winNum) {
        while (true) {
            try {
                OutputView.printBonusNumber();
                int bonusNumber = InputView.getBonusNumber();
                Validator.validateBonusNumber(winNum, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
