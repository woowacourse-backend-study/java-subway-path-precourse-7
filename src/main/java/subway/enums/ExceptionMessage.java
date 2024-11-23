package subway.enums;

public enum ExceptionMessage {

    EQUAL_DEPARTURE_AND_ARRIVAL("[ERROR] 출발역과 도착역이 동일합니다."),
    INVALID_ANSWER("[ERROR] 보기에 없는 입력입니다."),
    NOT_EXISTS_STATION("[ERROR] 지하철 노선에 존재하지 않는 역입니다."),
    NOT_CONNECTED_PATH("[ERROR] 출발역과 도착역이 이어져있지 않습니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String valueOf() {
        return message;
    }
}
