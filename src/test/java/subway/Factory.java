package subway;

import java.util.List;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Track;

public class Factory {

    public static void init() {
        String 교대 = "교대역";
        String 강남 = "강남역";
        String 역삼 = "역삼역";
        String 남부 = "남부터미널역";
        String 양재 = "양재역";
        String 양재시민 = "양재시민의숲역";
        String 매봉 = "매봉역";

        List<Track> track1s = List.of(new Track(교대, 강남, 2, 3),
                new Track(교대, 남부, 3, 2));
        Station station1 = new Station(교대, track1s);
        StationRepository.addStation(station1);

        List<Track> track2s = List.of(new Track(강남, 역삼, 2, 3),
                new Track(강남, 양재, 2, 8), new Track(강남, 교대, 2, 3));
        Station station2 = new Station(강남, track2s);
        StationRepository.addStation(station2);

        List<Track> track3s = List.of(new Track(역삼, 강남, 2, 3));
        Station station3 = new Station(역삼, track3s);
        StationRepository.addStation(station3);

        List<Track> track4s = List.of(new Track(남부, 교대, 3, 2),
                new Track(남부, 양재, 6, 5));
        Station station4 = new Station(남부, track4s);
        StationRepository.addStation(station4);

        List<Track> track5s = List.of(new Track(양재, 남부, 6, 5),
                new Track(양재, 강남, 2, 8), new Track(양재, 양재시민, 10, 3),
                new Track(양재, 매봉, 1, 1));
        Station station5 = new Station(양재, track5s);
        StationRepository.addStation(station5);

        List<Track> track6s = List.of(new Track(양재시민, 양재, 10, 3));
        Station station6 = new Station(양재시민, track6s);
        StationRepository.addStation(station6);

        List<Track> track7s = List.of(new Track(매봉, 양재, 1, 1));
        Station station7 = new Station(매봉, track7s);
        StationRepository.addStation(station7);
        //총 12개
    }
}
