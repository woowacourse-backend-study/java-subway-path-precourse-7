package subway.view;

import java.util.List;

public class OutputView {
    private final String MAIN_PROMPT = "## 메인 화면";
    private final String SEARCH_ROUTE = "1. 경로 조회";
    private final String TERMINATION = "Q. 종료";
    private final String USER_FUNCTION_INPUT_PROMPT = "## 원하는 기능을 선택하세요.";
    private final String ROUTE_CRITERIA_INPUT_PROMPT = "## 경로 기준";
    private final String SHORTEST_DISTANCE = "1. 최단 거리";
    private final String MINIMUM_TIME = "2. 최소 시간";
    private final String GO_BACK = "B. 돌아가기";
    private final String DEPARTURE_STATION_INPUT_PROMPT = "## 출발역을 입력하세요.";
    private final String ARRIVAL_STATION_INPUT_PROMPT = "## 도착역을 입력하세요.";

    public void printMainPrompt() {
        System.out.println(MAIN_PROMPT);
        System.out.println(SEARCH_ROUTE);
        System.out.println(TERMINATION);
        System.out.println();
    }

    public void printUserFunctionInputPrompt() {
        System.out.println(USER_FUNCTION_INPUT_PROMPT);
    }

    public void printFunctionCriteriaInputPrompt() {
        System.out.println(ROUTE_CRITERIA_INPUT_PROMPT);
        System.out.println(SHORTEST_DISTANCE);
        System.out.println(MINIMUM_TIME);
        System.out.println(GO_BACK);
    }

    public void printDepartureStationInputPrompt() {
        System.out.println(DEPARTURE_STATION_INPUT_PROMPT);
    }

    public void printArrivalStationInputPrompt() {
        System.out.println(ARRIVAL_STATION_INPUT_PROMPT);
    }

    public void printResultPrompt(double shortestDistance, double totalTime) {
        int parsedDistance = (int) shortestDistance;
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.printf("[INFO] 총 거리: %dkm%n", parsedDistance);
        System.out.printf("[INFO] 총 소요 시간: %.0f분%n", totalTime);
        System.out.println("[INFO] ---");
    }

    public void printRouteResultPrompt(List<String> shortestPath) {
        shortestPath.forEach(station -> System.out.println("[INFO] " + station));
    }
}
