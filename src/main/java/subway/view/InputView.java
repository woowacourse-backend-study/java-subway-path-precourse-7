package subway.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String enterMainOption() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return readLine().strip();
    }
}
