package subway.domain;

import subway.infrastructure.constants.ExceptionMessage;
import subway.infrastructure.exception.CustomException;

public class Station {
    public static int MIN = 2;
    public static int MAX = 10;
    private String name;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private void validateName(String name) {
        if (name.length() < MIN || name.length() > MAX) {
            throw new CustomException(ExceptionMessage.INVALID_STATION_NAME_LEN.getMessage());
        }
    }
}
