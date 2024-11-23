package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static subway.enums.ExceptionMessage.NOT_EXISTS_STATION;

import org.junit.jupiter.api.Test;
import subway.controller.SubwayInitializer;

public class StationRepositoryTest {

    @Test
    void 존재하지_않는_역을_조회하면_예외() {
        SubwayInitializer.INITIALIZER.initialize();

        assertThatThrownBy(() -> StationRepository.searchStationByName("건대입구역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_EXISTS_STATION.valueOf());
    }
}
