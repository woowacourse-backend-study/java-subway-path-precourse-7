package subway.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.MainOption;
import subway.domain.Station;
import subway.domain.StationInfo;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<MainOption,Controllable> controllers;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(MainOption.class);
        initializeControllers();
    }

    public void process() {

        MainOption option;
        do {
            outputView.printMainOption();
            option = doLoop(() -> MainOption.from(inputView.enterSelectOption()));
            controllers.get(option).process();
        } while (option.isPlayable());
        initStationInfo();
    }

    private void initializeControllers() {
        controllers.put(MainOption.FIND_ROUTE,new RouteController(inputView,outputView));
        controllers.put(MainOption.EXIT,new ExitController());
    }

    public void initStationInfo() {
        StationInfo[] stationInfos = StationInfo.values();
        for (StationInfo stationInfo : stationInfos) {
            StationRepository.addStation(Station.from(stationInfo.getName(), stationInfo.getConnectionStations()));
        }
        Line lineTwo = Line.valueOf("Line-2", StationRepository.findByName("교대역"), StationRepository.findByName("강남역"),
                StationRepository.findByName("역삼역"));
        Line lineThree = Line.valueOf("Line-3", StationRepository.findByName("교대역"), StationRepository.findByName("남부터미널역"),
                StationRepository.findByName("양재역"), StationRepository.findByName("매봉역"));
        Line lineBundang = Line.valueOf("Line-Bundang", StationRepository.findByName("강남역"),
                StationRepository.findByName("양재역"),
                StationRepository.findByName("양재시민의숲역"));
        LineRepository.addLine(lineTwo);
        LineRepository.addLine(lineThree);
        LineRepository.addLine(lineBundang);
    }

    private <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
