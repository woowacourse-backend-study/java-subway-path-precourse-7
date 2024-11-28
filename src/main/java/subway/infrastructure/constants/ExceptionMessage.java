package subway.infrastructure.constants;

import subway.domain.Edge;
import subway.domain.Station;

public enum ExceptionMessage {
    INVALID_STATION_NAME_LEN(String.format("역 이름은 최소 %,d자에서 최대 %,d자까지 가능합니다.", Station.MIN, Station.MAX)),
    INVALID_DISTANCE(
            String.format("역 사이 거리는 %,dkm 이상 %,dkm 이하까지 가능합니다.", Edge.MIN_DISTANCE, Edge.MAX_DISTANCE)
    ),
    INVALID_TIME(String.format("역 사이 시간은 %,d분 이상 %,d분 이하까지 가능합니다.", Edge.MIN_TIME, Edge.MAX_TIME)),
    NOT_EXIST_STATION("존재하지 않는 역이 입력되었습니다."),
    ;

    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
