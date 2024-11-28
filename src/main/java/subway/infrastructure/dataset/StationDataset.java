package subway.infrastructure.dataset;

import subway.domain.Station;

import java.util.Arrays;
import java.util.List;

public enum StationDataset {
    교대역(new Station("교대역")),
    강남역(new Station("강남역")),
    역삼역(new Station("역삼역")),
    남부터미널역(new Station("남부터미널역")),
    양재역(new Station("양재역")),
    매봉역(new Station("매봉역")),
    양재시민의숲역(new Station("양재시민의숲역"))
    ;

    private final Station station;

    private StationDataset(Station station) {
        this.station = station;
    }

    public Station getData() {
        return station;
    }

    public static List<Station> getStations() {
        return Arrays.stream(values())
                .map(StationDataset::getData)
                .toList();
    }
}
