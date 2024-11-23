package subway.domain.search;

import java.util.List;

public interface PathSearch {

    List<String> search(String departure, String arrival);
}
