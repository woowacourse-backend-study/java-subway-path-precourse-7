package enums;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import subway.enums.ExceptionMessage;
import subway.enums.MainAnswers;

public class MainAnswersTest {

    @Test
    void 잘못된_입력_시_예외() {
        assertThatThrownBy(() -> MainAnswers.checkAnswer("2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ANSWER.valueOf());
    }
}
