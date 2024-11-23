package subway;

import subway.controller.DistanceController;
import subway.controller.HourController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        initLine();
        initStation();

        while (true) {
            OutputView.printMain();
            String userInput = InputView.inputLine();
            if (userInput.equals("1")) {
                OutputView.printFunction();
                String functionInput = InputView.inputLine();
                if (functionInput.equals("1") || functionInput.equals("2")) {
                    OutputView.printStartStation();
                    String startStation = InputView.inputStation();
                    OutputView.printEndStation();
                    String endStation = InputView.inputStation();
                    if (startStation.equals(endStation)) {
                        System.out.println("[ERROR] 출발역과 도착역이 동일합니다.");
                    }
                    if (functionInput.equals("1")) {
                        new DistanceController(startStation, endStation);
                    }
                    if (functionInput.equals("2")) {
                        new HourController(startStation, endStation);
                    }
                }
            }
            if (userInput.equals("Q")) {
                return;
            }
        }
    }

    private static void initStation() {
        String[] stations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        for (String stationName : stations) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private static void initLine() {
        String[] lines = {"2호선", "3호선", "신분당선"};
        for (String lineName : lines) {
            Line line = new Line(lineName);
            LineRepository.addLine(line);
        }
    }
}
