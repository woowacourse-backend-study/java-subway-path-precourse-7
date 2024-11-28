package subway.infrastructure.constants;

import subway.domain.Station;

public enum ExceptionMessage {
    INVALID_STATION_NAME_LEN(String.format("역 이름은 최소 %,d자에서 최대 %,d자까지 가능합니다.", Station.MIN, Station.MAX)),
    ;

    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
