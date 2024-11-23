package subway;

import subway.dto.UserFunctionInput;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();

        outputView.printMainPrompt();

        outputView.printUserFunctionInputPrompt();

        InputView inputView = new InputView();
        UserFunctionInput userFunctionInput = inputView.userFunctionInput();

    }
}
