package subway.controller;

import subway.domain.vo.Path;
import subway.infrastructure.ErrorException;
import subway.service.InitializeService;
import subway.service.InputValidator;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InitializeService initializeService;
    private final PathService pathService;
    private final InputValidator inputValidator;

    public SubwayController(
            InputView inputView,
            OutputView outputView,
            InitializeService initializeService,
            PathService pathService,
            InputValidator inputValidator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initializeService = initializeService;
        this.pathService = pathService;
        this.inputValidator = inputValidator;
    }

    public void run() {
        initializeService.init();
        while (true) {
            outputView.printMain();
            String function = getFunction();
            if (function.equals("Q")) return;
            outputView.printStandard();
            String standard = getStandard();
            if (standard.equals("B")) continue;
            Path path = getPath(standard);
            outputView.printPathResult(path);
        }
    }

    private String getFunction() {
        while (true) {
            try {
                return inputView.getFunction();
            } catch (ErrorException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getStandard() {
        while (true) {
            try {
                return inputView.getStandard();
            } catch (ErrorException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Path getPath(String standard) {
        String start = getStart();
        String dest = getDest(start);

        if (standard.equals("1")) { // 최단거리
            return pathService.getDistancePath(start, dest);
        }
        return pathService.getTimePath(start, dest);
    }

    private String getStart() {
        while (true) {
            try {
                String startStation = inputView.getStartStation();
                inputValidator.validateStation(startStation);
                return startStation;
            } catch (ErrorException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getDest(String start) {
        while (true) {
            try {
                String destStation = inputView.getDestStation();
                inputValidator.validateStation(destStation);
                inputValidator.validateStations(start, destStation);
                return destStation;
            } catch (ErrorException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
