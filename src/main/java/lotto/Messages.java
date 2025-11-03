package lotto;

public class Messages {
    static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    static final String ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    static final String VIEW_PURCHASE_TOTAL_LOTTO = "개를 구매했습니다.";

    static final String ERROR_PURCHASE_AMOUNT_NOT_POSITIVE = "[ERROR] 구입 금액은 0보다 큰 양수여야 합니다.";
    static final String ERROR_PURCHASE_AMOUNT_NOT_IN_UNITS = "[ERROR] 구입 금액은 %,d원 단위로 입력해야합니다";
    static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final String ERROR_LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    static final String ERROR_LOTTO_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    static final String ERROR_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    static final String ERROR_NUMBER_NOT_NUMBER = "[ERROR] 로또 번호는 숫자만 입력 가능합니다.";
    static final String ERROR_WINNING_NUMBER_DUPLICATE = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";
    static final String ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
}
