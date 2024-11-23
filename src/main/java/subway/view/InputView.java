package subway.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String enterSelectOption() {
        println();
        System.out.println("## 원하는 기능을 선택하세요.");
        return readLine().strip();
    }

    private void println() {
        System.out.println();
    }
}
