package subway.domain;

import java.util.Comparator;
import java.util.List;

public class PathPolicy {

    private Policy policy;

    public PathPolicy(Policy policy) {
        this.policy = policy;
    }

    public boolean isBetterThan(Path ownPath, Path comparePath) {
        if (policy.equals(Policy.LOW_PRICE)) {
            return ownPath.isLowPriceThan(comparePath);
        }
        return ownPath.isShortDistanceThan(comparePath);
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
