package subway.view;

import java.util.List;

public class OutputView {

    private static final String EXPECTED_RESULT_KEYWORD = "[INFO]";
    private static final String SPACE = " ";

    public void showMainDisplay() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료\n");
    }

    public void showPathStandardSelectDisplay() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기\n");
    }

    public void showShortestPathResult(int distance, int time, List<String> shortestPath) {
        System.out.println("## 조회 결과");
        System.out.println(EXPECTED_RESULT_KEYWORD + SPACE + "-".repeat(3));
        System.out.println(EXPECTED_RESULT_KEYWORD + SPACE + "총 거리: " + distance + "km");
        System.out.println(EXPECTED_RESULT_KEYWORD + SPACE + "총 소요 시간: " + time + "분");
        System.out.println(EXPECTED_RESULT_KEYWORD + SPACE + "-".repeat(3));
        shortestPath.forEach(path -> System.out.println(EXPECTED_RESULT_KEYWORD + " " + path));
    }
}
