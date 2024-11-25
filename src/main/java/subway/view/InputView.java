package subway.view;

import java.util.Scanner;
import subway.service.PathStandard;

public class InputView {
    private static final String INPUT_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String END_STATION_MESSAGE = "## 도착역을 입력하세요.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainOption inputMainOption() {
        System.out.println(INPUT_OPTION_MESSAGE);
        return MainOption.from(scanner.nextLine().trim());
    }

    public PathStandard inputPathStandard() {
        System.out.println(INPUT_OPTION_MESSAGE);
        return PathStandard.from(scanner.nextLine().trim());
    }

    public String inputStartStation() {
        System.out.println(START_STATION_MESSAGE);
        return scanner.nextLine().trim();
    }

    public String inputEndStation() {
        System.out.println(END_STATION_MESSAGE);
        return scanner.nextLine().trim();
    }
}