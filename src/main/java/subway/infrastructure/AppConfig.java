package subway.infrastructure;

import subway.controller.SubwayController;
import subway.service.InitializeService;
import subway.service.InputValidator;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;

public class AppConfig {
    public SubwayController controller() {
        return new SubwayController(
                new InputView(),
                new OutputView(),
                new InitializeService(),
                new PathService(),
                new InputValidator()
        );
    }
}
