package subway.domain.search;

import java.util.List;
import subway.domain.TimeRepository;

public class TotalTimeCalculator {

    public int calculateTotalTime(List<String> shortestPath) {
        int totalTime = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            totalTime += TimeRepository.searchTimeByName(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return totalTime;
    }
}
