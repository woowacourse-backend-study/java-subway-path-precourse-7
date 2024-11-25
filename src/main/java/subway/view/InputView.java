package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MAIN_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private final Scanner scanner;
    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }
    public MainOption inputMainFeature() {
        System.out.println(INPUT_MAIN_FEATURE_MESSAGE);
        return MainOption.from(scanner.nextLine());
    }
}