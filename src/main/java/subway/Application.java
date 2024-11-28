package subway;

import subway.controller.MainController;
import subway.controller.PathController;
import subway.service.InitializeDatasetService;
import subway.service.InputValidator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainController controller = new MainController(
                new InitializeDatasetService(),
                new PathController(new OutputView(), new InputView(), new InputValidator()),
                new OutputView(),
                new InputView()
        );
        controller.run();
    }
}
