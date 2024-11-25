package subway.view;

import subway.dto.PathResponseDto;
import subway.service.PathStandard;

public class OutputView {

    private static final String MAIN_OPTION_MESSAGE = "## 메인 화면";
    private static final String PATH_STANDARD_MESSAGE = "## 경로 기준";
    private static final String PATH_RESULT_MESSAGE = "## 조회 결과";
    private static final String INFO_SEPERATE = "[INFO] ---";

    private OutputView() {
    }

    public static void printMainFeature() {
        System.out.println(MAIN_OPTION_MESSAGE);
        for (MainOption mainOption : MainOption.values()) {
            System.out.println(mainOption.toDto());
        }
        printBlank();
    }

    public static void printPathStandard() {
        System.out.println(PATH_STANDARD_MESSAGE);
        for (PathStandard pathStandard : PathStandard.values()) {
            System.out.println(pathStandard.toDto());
        }
        printBlank();
    }

    public static void printPathResult(PathResponseDto responseDto) {
        System.out.println(PATH_RESULT_MESSAGE);
        System.out.println(INFO_SEPERATE);
        printDistance(responseDto);
        printTime(responseDto);
        System.out.println(INFO_SEPERATE);
        printRoute(responseDto);
        printBlank();
    }

    private static void printDistance(PathResponseDto responseDto) {
        System.out.printf("[INFO] 총 거리: %dkm%n", responseDto.distance());
    }

    private static void printTime(PathResponseDto responseDto) {
        System.out.printf("[INFO] 총 소요 시간: %d분%n", responseDto.time());
    }

    private static void printRoute(PathResponseDto responseDto) {
        for (String stationName : responseDto.route()) {
            System.out.printf("[INFO] %s%n", stationName);
        }
    }

    private static void printBlank() {
        System.out.println();
    }
}