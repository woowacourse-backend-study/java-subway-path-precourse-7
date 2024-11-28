package subway.view;

import subway.domain.Path;
import subway.domain.Station;
import subway.service.dto.PathResult;

import java.util.List;

public class OutputView {
    private static final String DIVISION_LINE = "---";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printTitle(String title) {
        System.out.printf("## %s\n", title);
    }

    public void printOptions(List<String> options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void printInfo(String message) {
        System.out.printf("[INFO] %s\n", message);
    }

    public void printPathResult(PathResult pathInfo) {
        printPathInfo(pathInfo.distance(), pathInfo.time());
        printPath(pathInfo.path());
    }

    private void printPathInfo(int distance, int time) {
        printInfo(DIVISION_LINE);
        printInfo(String.format("총 거리: %,dkm", distance));
        printInfo(String.format("총 소요 시간: %,d분", time));
        printInfo(DIVISION_LINE);
    }

    private void printPath(Path path) {
        List<Station> stations = path.value();
        for (Station station : stations) {
            printInfo(station.getName());
        }
    }
}
