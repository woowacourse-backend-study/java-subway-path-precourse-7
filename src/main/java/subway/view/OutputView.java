package subway.view;

import subway.domain.vo.Path;

public class OutputView {
    private static final String PRINT_PREFIX = "[INFO]";
    private static final String LINE = "---";

    public void printMain() {
        printTitle("메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public void printStandard() {
        printTitle("경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public void printPathResult(Path path) {
        printTitle("조회 결과");
        printInfo(LINE);
        printInfo(path.getDistanceInfo());
        printInfo(path.getTimeInfo());
        printInfo(LINE);
        for (String station : path.getPathInfo()) {
            printInfo(station);
        }
    }

    private void printTitle(String title) {
        System.out.printf("%n## %s%n", title);
    }

    private void printInfo(String text) {
        System.out.printf("%s %s%n", PRINT_PREFIX, text);
    }
}
