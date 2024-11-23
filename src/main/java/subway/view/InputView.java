package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.infrastructure.ErrorException;

import java.util.List;

public class InputView {
    private final static List<String> FUNCTION_ANSWERS = List.of("1", "Q");
    private final static List<String> STANDARD_ANSWERS = List.of("1", "2", "B");

    public String getFunction() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String answer = Console.readLine().trim();
        if (!FUNCTION_ANSWERS.contains(answer)) {
            throw new ErrorException("입력 값이 올바르지 않습니다.");
        }
        return answer;
    }

    public String getStandard() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String answer = Console.readLine().trim();
        if (!STANDARD_ANSWERS.contains(answer)) {
            throw new ErrorException("입력 값이 올바르지 않습니다.");
        }
        return answer;
    }

    public String getStartStation() {
        System.out.println("\n## 출발역을 입력하세요.");
        return Console.readLine().trim();
    }

    public String getDestStation() {
        System.out.println("\n## 도착역을 입력하세요.");
        return Console.readLine().trim();
    }
}
