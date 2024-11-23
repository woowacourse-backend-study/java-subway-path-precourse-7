package subway.controller;

import java.util.List;
import subway.enums.MainAnswers;
import subway.enums.SubMenuAnswers;
import subway.exception.Validator;
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
        // 초기화
        SubwayInitializer.INITIALIZER.initialize();
        Validator validator = new Validator();

        // 메인 화면
        String mainAnswer = null;
        while (mainAnswer == null) {
            try {
                outputView.showMainDisplay();
                mainAnswer = MainAnswers.checkAnswer(inputView.inputFeature());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        outputView.showPathStandardSelectDisplay();
        String pathStandardAnswer = inputView.inputFeature();
        SubMenuAnswers.checkAnswer(pathStandardAnswer);

        String departure = inputView.inputDepartureStation();
        String arrival = inputView.inputArrivalStation();
        validator.validateStationAnswer(departure, arrival);

        // 경로 찾기 기능 수행 (경로, 시간 flag)
        outputView.showShortestPathResult(3, 10, List.of("교대역", "강남역"));
    }
}
