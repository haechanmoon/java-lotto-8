package lotto.domain;

import java.util.List;
import lotto.utils.Messages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_SIZE_OVER);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
    //와 드디어 돌아가는 코드가 완성되었다.
    //toString() 부르면 자동으로 []랑 , 를 만들어주는구나. 진짜 몰랐음.
    //괜히 개고생했네. 뭐 어쨌든. 돌아가니까. 여기까지만하고. 내일 테스트코드부터 다시 시작하자!!

}
