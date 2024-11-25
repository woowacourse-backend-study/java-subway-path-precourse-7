package subway.domain;

import java.util.Comparator;
import java.util.List;

public class PathPolicy {

    private Policy policy;

    public PathPolicy(Policy policy) {
        this.policy = policy;
    }

    public boolean isBetterThan(Track ownTrack, Track compareTrack) {
        if (policy.equals(Policy.LOW_PRICE)) {
            return ownTrack.getPrice() <= compareTrack.getPrice();
        }
        return ownTrack.getDistance() <= ownTrack.getDistance();
    }

    public Track getPolicyTrack(List<Track> tracks) {
        if (policy.equals(Policy.LOW_PRICE)) {
            return tracks.stream()
                    .min(Comparator.comparing(Track::getPrice))
                    .get();
        }
        return tracks.stream()
                .min(Comparator.comparing(Track::getDistance))
                .get();
    }
}
