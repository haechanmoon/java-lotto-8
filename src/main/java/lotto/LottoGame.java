package lotto;

public class LottoGame {
    private final InputView inputView;

    public LottoGame() {
        this.inputView = new InputView();
    }

    public void start() {
        int amount = inputView.getPurchaseAmount();
        int lottoCount = amount / 1000;
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }
}