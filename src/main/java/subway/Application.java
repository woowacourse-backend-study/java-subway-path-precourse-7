package subway;

import subway.controller.MainController;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(
                new InputView(),
                new OutputView()
        );

        mainController.process();
    }
}
