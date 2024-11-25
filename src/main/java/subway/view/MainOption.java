package subway.view;

import java.util.Arrays;

public enum MainOption {
    PATH_GET("1", "경로 조회"),
    QUIT("Q", "종료");

    private static final String INVALID_INPUT_MAINOPTION = "[ERROR] 메인 기능은 1, Q 중에서 입력 가능합니다.";
    private final String number;
    private final String name;

    MainOption(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static MainOption from(String number) {
        return Arrays.stream(MainOption.values())
                .filter(mainOption -> mainOption.isEqualNumber(number))
                .findFirst()
                .orElseThrow(() ->
                new IllegalArgumentException(INVALID_INPUT_MAINOPTION)); // 수정된 부분
    }

    private boolean isEqualNumber(String number) {
        return this.number.equals(number);
    }
    public String toDto(){
        return String.format("%s. %s", this.number, this.name);
    }
    public boolean isPathGet(){
        return this == PATH_GET;
    }
    public boolean isQuit(){
        return this == QUIT;
    }
}