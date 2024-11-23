package subway.controller;

import java.util.List;
import subway.domain.DistanceRepository;
import subway.domain.StationRepository;
import subway.domain.TimeRepository;
import subway.domain.search.ShortestDistancePathSearch;
import subway.domain.search.ShortestTimePathSearch;

public class SubwayPathController implements Controller {

    private final SubMenuController subMenuController;

    public SubwayPathController(SubMenuController subMenuController) {
        this.subMenuController = subMenuController;
    }

    public void startFindPath(String subMenuAnswer) {
        String departure = answerDeparture();
        String arrival = answerArrival();

        if (subMenuAnswer.equals("1")) {
            handleShortestDistanceCase(departure, arrival);
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

    private void handleShortestDistanceCase(String departure, String arrival) {
        List<String> shortestPath = new ShortestDistancePathSearch().search(departure, arrival);
        outputView.showShortestPathResult(calculateTotalDistance(shortestPath), calculateTotalTime(shortestPath),
                shortestPath);
    }

    private void handleShortestTimeCase(String departure, String arrival) {
        List<String> shortestPath = new ShortestTimePathSearch().search(departure, arrival);
        outputView.showShortestPathResult(calculateTotalDistance(shortestPath), calculateTotalTime(shortestPath),
                shortestPath);
    }

    private int calculateTotalTime(List<String> shortestPath) {
        int totalTime = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            totalTime += TimeRepository.searchTimeByName(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return totalTime;
    }

    private int calculateTotalDistance(List<String> shortestPath) {
        int totalDistance = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            totalDistance += DistanceRepository.searchDistanceByName(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return totalDistance;
    }
}
