package subway.controller;

import subway.controller.vo.PathStandardOption;
import subway.infrastructure.exception.CustomException;
import subway.service.DistancePathService;
import subway.service.InputValidator;
import subway.service.PathService;
import subway.service.TimePathService;
import subway.service.dto.PathResult;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.function.Supplier;

public class PathController {
    private static final String TITLE = "경로 기준";
    EnumMap<PathStandardOption, PathService> pathServiceMapper = new EnumMap<>(PathStandardOption.class);
    private final OutputView outputView;
    private final InputView inputView;
    private final InputValidator inputValidator;

    public PathController(
            OutputView outputView,
            InputView inputView,
            InputValidator inputValidator
    ) {
        initMapper();
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    private void initMapper() {
        pathServiceMapper.put(PathStandardOption.DISTANCE, new DistancePathService());
        pathServiceMapper.put(PathStandardOption.TIME, new TimePathService());
    }

    public void process() {
        PathStandardOption option = doLoop(this::getPathOption);
        if (option == PathStandardOption.GO_BACK) {
            return;
        }
        try {
            handlePath(option);
        } catch (CustomException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    private PathStandardOption getPathOption() {
        outputView.printTitle(TITLE);
        outputView.printOptions(PathStandardOption.getTitles());
        return inputView.readPathOption();
    }

    private void handlePath(PathStandardOption option) {
        PathService pathService = pathServiceMapper.get(option);
        String startStation = doLoop(this::getStartStation);
        String destStation = doLoop(this::getDestStation);
        inputValidator.validateStationDifferent(startStation, destStation);

        PathResult pathResult = pathService.getPathResult(startStation, destStation);
        outputView.printPathResult(pathResult);
    }

    private String getStartStation() {
        String station = inputView.readStartStation();
        inputValidator.validateStation(station);
        return station;
    }

    private String getDestStation() {
        String station = inputView.readDestStation();
        inputValidator.validateStation(station);
        return station;
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
