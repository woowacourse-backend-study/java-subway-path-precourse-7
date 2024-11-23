package subway;

import java.util.Scanner;
import subway.controller.MainController;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainController controller = new MainController(new InputView(), new OutputView());
        controller.start();
    }
}
