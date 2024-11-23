package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.dto.UserFunctionInput;

public class InputView {

    public UserFunctionInput userFunctionInput() {
        String input = Console.readLine();
        return UserFunctionInput.from(input);
    }
}
