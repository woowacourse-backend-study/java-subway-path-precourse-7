package subway.controller;

import java.util.List;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.search.ShortestDistancePathSearch;
import subway.domain.search.ShortestTimePathSearch;
import subway.domain.search.TotalDistanceCalculator;
import subway.domain.search.TotalTimeCalculator;

public class SubwayPathController implements Controller {

    private static final String SHORTEST_DISTANCE_OPTION = "1";

    private final SubMenuController subMenuController;
    private final TotalDistanceCalculator totalDistanceCalculator;
    private final TotalTimeCalculator totalTimeCalculator;

    public SubwayPathController(SubMenuController subMenuController) {
        this.subMenuController = subMenuController;
        this.totalDistanceCalculator = new TotalDistanceCalculator();
        this.totalTimeCalculator = new TotalTimeCalculator();
    }

    public void startFindPath(String subMenuAnswer) {
        String departure = answerDeparture();
        String arrival = answerArrival();

        checkEqualsName(departure, arrival);

        if (subMenuAnswer.equals(SHORTEST_DISTANCE_OPTION)) {
            handleShortestDistanceCase(departure, arrival);
            return;
        }
        handleShortestTimeCase(departure, arrival);
    }

    private String answerDeparture() {
        String departure = null;
        try {
            departure = StationRepository.searchStationByName(inputView.inputDepartureStation());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            subMenuController.startSubMenu();
        }
        return departure;
    }

    private String answerArrival() {
        String arrival = null;
        try {
            arrival = StationRepository.searchStationByName(inputView.inputArrivalStation());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            subMenuController.startSubMenu();
        }
        return arrival;
    }

    private void checkEqualsName(String departure, String arrival) {
        Station station = new Station(StationRepository.searchStationByName(departure));
        try {
            station.checkSameName(arrival);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            subMenuController.startSubMenu();
        }
    }

    private void handleShortestDistanceCase(String departure, String arrival) {
        List<String> shortestPath = new ShortestDistancePathSearch().search(departure, arrival);
        outputView.showShortestPathResult(totalDistanceCalculator.calculateTotalDistance(shortestPath),
                totalTimeCalculator.calculateTotalTime(shortestPath), shortestPath);
    }

    private void handleShortestTimeCase(String departure, String arrival) {
        List<String> shortestPath = new ShortestTimePathSearch().search(departure, arrival);
        outputView.showShortestPathResult(totalDistanceCalculator.calculateTotalDistance(shortestPath),
                totalTimeCalculator.calculateTotalTime(shortestPath), shortestPath);
    }
}
