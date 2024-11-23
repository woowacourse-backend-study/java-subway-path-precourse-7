package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public interface Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
}
