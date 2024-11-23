package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class RouteController implements Controllable{

    private final InputView inputView;
    private final OutputView outputView;

    public RouteController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        System.out.println("루트 조회 경로");
    }
}
