package subway.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import subway.domain.StationRepository;


public class InputView {

    public static String inputLine() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return Console.readLine().trim();
    }

    public static String inputStation() {
        List<String> stationNames = StationRepository.getNames();
        while (true) {
            String inputStation = Console.readLine().trim();
            if (stationNames.contains(inputStation)) {
                return inputStation;
            }
            System.out.println("[ERROR]역 이름을 확인해 주세요");
        }
    }
}
