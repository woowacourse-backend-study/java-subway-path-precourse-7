package subway.domain.search;

import java.util.List;
import subway.domain.DistanceRepository;

public class TotalDistanceCalculator {

    public int calculateTotalDistance(List<String> shortestPath) {
        int totalDistance = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            totalDistance += DistanceRepository.searchDistanceByName(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return totalDistance;
    }
}
