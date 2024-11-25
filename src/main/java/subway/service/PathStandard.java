package subway.service;

import static java.lang.String.format;

import java.util.Arrays;

public enum PathStandard {

    SHORTEST_DISTANCE("1","최단거리"),
    SHORTEST_TIME("2","최소 시간"),
    BACK("B", "돌아가기");

    private static final String INVALID_PATH_STANDARD_MESSAGE= "[ERROR] 경로 기준은 1, 2, B 중에 입력 가능합니다.";
    private final String name;
    private final String number;

    PathStandard(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public static PathStandard from(String number) {
        return Arrays.stream(PathStandard.values())
                .filter(pathStandard -> pathStandard.isEqualNumber(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PATH_STANDARD_MESSAGE));
    }

    private boolean isEqualNumber(String number) {
        return this.number.equals(number);
    }

    public boolean isDistance(){
        return this == SHORTEST_DISTANCE;
    }
    public boolean isTime(){
        return this == SHORTEST_TIME;
    }
    public String toDto() {
        return String.format("%s. %s", number, name);
    }
}
