package subway.enums;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class SubMenuAnswersTest {

    @Test
    void 잘못된_입력_시_예외() {
        assertThatThrownBy(() -> SubMenuAnswers.checkAnswer("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ANSWER.valueOf());
    }
}
