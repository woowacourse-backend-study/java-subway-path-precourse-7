package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.dto.CriteriaFunctionInput;
import subway.dto.MainFunctionInput;

public class InputView {

    public MainFunctionInput mainFunctionInput() {
        String input = Console.readLine();
        return MainFunctionInput.from(input);
    }

    public CriteriaFunctionInput criteriaFunctionInput() {
        String input = Console.readLine();
        return CriteriaFunctionInput.from(input);
    }
}
