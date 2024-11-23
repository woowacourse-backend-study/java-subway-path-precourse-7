package subway.controller;

import java.util.List;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.showMainDisplay();

        outputView.showPathStandardSelectDisplay();

        outputView.showShortestPathResult(3, 10, List.of("교대역", "강남역"));
    }
}
