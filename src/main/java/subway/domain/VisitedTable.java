package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitedTable {

    private Map<String, Boolean> visitedMap;

    public VisitedTable(Station sourceStation, List<Station> stations) {
        visitedMap = new HashMap<>();
        for (Station station : stations) {
            String name = station.getName();
            visitedMap.put(name, Boolean.FALSE);
        }
        visited(sourceStation);
    }

    public boolean isVisited(Station station) {
        if (!visitedMap.containsKey(station.getName())) {
            throw new RuntimeException("존재하지 않는 역입니다");
        }

        Boolean aBoolean = visitedMap.get(station.getName());
        return aBoolean;
    }

    public void visited(Station station) {
        if (isVisited(station)) {
            throw new RuntimeException("이미 방문한 역입니다");
        }
        visitedMap.put(station.getName(), Boolean.TRUE);
    }
}
