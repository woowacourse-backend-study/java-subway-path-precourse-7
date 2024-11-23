package subway.view;

import java.util.List;

public class OutputView {
    public static void printMain() {
        System.out.println("\n## 메인 화면\n1. 경로 조회\nQ. 종료");
    }

    public static void printFunction() {
        System.out.println("\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기");
    }

    public static void printStartStation() {
        System.out.println("\n## 출발역을 입력하세요.");
    }

    public static void printEndStation() {
        System.out.println("\n## 도착역을 입력하세요.");
    }

    public static void printResult(int distance, int time, List<String> paths) {

        System.out.println("\n## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: " + distance + "km");
        System.out.println("[INFO] 총 소요 시간: " + time + "분");
        System.out.println("[INFO] ---");
        for (String path : paths) {
            System.out.println("[INFO] " + path);
        }
    }
}
