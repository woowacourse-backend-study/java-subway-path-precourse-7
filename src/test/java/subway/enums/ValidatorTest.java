package subway.enums;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import subway.exception.Validator;

public class ValidatorTest {

    @Test
    void 출발지와_도착지가_같으면_예외() {
        assertThatThrownBy(() -> new Validator().validateStationAnswer("교대역", "교대역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EQUAL_DEPARTURE_AND_ARRIVAL.valueOf());
    }
}
