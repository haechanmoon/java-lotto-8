package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        int amount = inputView.getPurchaseAmount();
        int lottoCount = amount / 1000;
        outputView.printLottoCount(lottoCount);
        List<Lotto> purchasedLottos = generateLottos(lottoCount);
        outputView.printLottos(purchasedLottos);
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumbers);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}