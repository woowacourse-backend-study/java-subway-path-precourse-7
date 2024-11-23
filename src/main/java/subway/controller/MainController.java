package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationInfo;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void process() {
        outputView.printMainOption();
        initStationInfo();
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
}
