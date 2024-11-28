package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.infrastructure.dataset.LineDataset;
import subway.infrastructure.dataset.StationDataset;

import java.util.List;

public class InitializeDatasetService {
    public void init() {
        initLines();
        initStations();
    }

    private void initLines() {
        List<Line> lines = LineDataset.getLines();
        for (Line line : lines) {
            LineRepository.addLine(line);
        }
    }

    private void initStations() {
        List<Station> stations = StationDataset.getStations();
        for (Station station : stations) {
            StationRepository.addStation(station);
        }
    }
}
