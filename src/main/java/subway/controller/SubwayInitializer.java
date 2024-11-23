package subway.controller;

import subway.domain.Distance;
import subway.domain.DistanceRepository;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Time;
import subway.domain.TimeRepository;

public enum SubwayInitializer {

    INITIALIZER;

    public void initialize() {
        initStations();
        initLines();
        initDistances();
        initTimes();
    }

    private void initStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private void initLines() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private void initDistances() {
        DistanceRepository.addDistance(new Distance("교대역", "강남역", 2));
        DistanceRepository.addDistance(new Distance("강남역", "역삼역", 2));
        DistanceRepository.addDistance(new Distance("교대역", "남부터미널역", 3));
        DistanceRepository.addDistance(new Distance("남부터미널역", "양재역", 6));
        DistanceRepository.addDistance(new Distance("양재역", "매봉역", 1));
        DistanceRepository.addDistance(new Distance("강남역", "양재역", 2));
        DistanceRepository.addDistance(new Distance("양재역", "양재시민의숲역", 10));
    }

    private void initTimes() {
        TimeRepository.addTime(new Time("교대역", "강남역", 3));
        TimeRepository.addTime(new Time("강남역", "역삼역", 3));
        TimeRepository.addTime(new Time("교대역", "남부터미널역", 2));
        TimeRepository.addTime(new Time("남부터미널역", "양재역", 5));
        TimeRepository.addTime(new Time("양재역", "매봉역", 1));
        TimeRepository.addTime(new Time("강남역", "양재역", 8));
        TimeRepository.addTime(new Time("양재역", "양재시민의숲역", 3));
    }
}
