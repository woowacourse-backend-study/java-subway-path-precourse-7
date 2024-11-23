package subway;

import subway.dto.ArrivalStationInput;
import subway.dto.CriteriaFunctionInput;
import subway.dto.DepartureStationInput;
import subway.dto.MainFunctionInput;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.DistanceGraphService;
import subway.service.TimeGraphService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        StationRepository.initializeStations();
        LineRepository.initializeLines();

        OutputView outputView = new OutputView();
        outputView.printMainPrompt();
        outputView.printUserFunctionInputPrompt();

        InputView inputView = new InputView();
        MainFunctionInput userFunctionInput = inputView.readMainFunctionInput();
        System.out.println();

        outputView.printFunctionCriteriaInputPrompt();
        CriteriaFunctionInput criteriaFunctionInput = inputView.readCriteriaFunctionInput();

        outputView.printDepartureStationInputPrompt();
        DepartureStationInput departureStationInput = inputView.readDepartureStationInput();
        String start = departureStationInput.getInput();

        outputView.printArrivalStationInputPrompt();
        ArrivalStationInput arrivalStationInput = inputView.readArrivalStationInput();
        String end = arrivalStationInput.getInput();

        if (start.equals(end)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 동일합니다.");
        }

        if (Objects.equals(criteriaFunctionInput.getInput(), "1")) {
            DistanceGraphService distanceGraphService = new DistanceGraphService();

            List<String> shortestPath = distanceGraphService.getShortestPath(start, end);
            double shortestDistance = distanceGraphService.getShortestDistance(start, end);
            double totalTime = distanceGraphService.getTotalTime(start, end);

            outputView.printResultPrompt(shortestDistance, totalTime);

            outputView.printRouteResultPrompt(shortestPath);
        }

        if (Objects.equals(criteriaFunctionInput.getInput(), "2")) {
            TimeGraphService timeGraphService = new TimeGraphService();

            List<String> fastestPath = timeGraphService.getFastestPath(start, end);
            double fastestTime = timeGraphService.getFastestTime(start, end);
            double totalDistance = timeGraphService.getTotalDistance(start, end);

            outputView.printResultPrompt(totalDistance, fastestTime);

            outputView.printRouteResultPrompt(fastestPath);
        }
    }
}
