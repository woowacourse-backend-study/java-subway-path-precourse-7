package subway.domain;

import java.util.List;

public class Station {
    private String name;
    private List<Track> tracks;

    public Station(String name, List<Track> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public Track move(String name) {
        for (Track track : tracks) {
            if (track.getDestinationName().equals(name)) {
                return track;
            }
        }
        throw new RuntimeException("찾을 수 없는 역 입니다");
    }

    public List<Track> getTracks() {
        return tracks;
    }
    // 추가 기능 구현
}
