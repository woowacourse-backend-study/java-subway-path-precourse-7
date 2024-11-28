package subway.controller;

import subway.controller.vo.MainOption;
import subway.infrastructure.exception.CustomException;
import subway.service.InitializeDatasetService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.function.Supplier;

public class MainController {
    private static final String TITLE = "메인 화면";
    private final InitializeDatasetService initializeDatasetService;
    private final PathController pathController;
    private final OutputView outputView;
    private final InputView inputView;

    public MainController(
            InitializeDatasetService initializeDatasetService,
            PathController pathController,
            OutputView outputView,
            InputView inputView
    ) {
        this.initializeDatasetService = initializeDatasetService;
        this.pathController = pathController;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        initializeDatasetService.init();
        while (getOption() != MainOption.EXIT) {
            pathController.process();
        }
    }

    private MainOption getOption() {
        outputView.printTitle(TITLE);
        outputView.printOptions(MainOption.getTitles());
        return doLoop(inputView::readMainOption);
    }

    private <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (CustomException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}
