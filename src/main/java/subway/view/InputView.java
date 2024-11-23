package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.dto.ArrivalStationInput;
import subway.dto.CriteriaFunctionInput;
import subway.dto.DepartureStationInput;
import subway.dto.MainFunctionInput;

public class InputView {

    public MainFunctionInput readMainFunctionInput() {
        String input = Console.readLine();
        return MainFunctionInput.from(input);
    }

    public CriteriaFunctionInput readCriteriaFunctionInput() {
        String input = Console.readLine();
        return CriteriaFunctionInput.from(input);
    }

    public DepartureStationInput readDepartureStationInput() {
        String input = Console.readLine();
        return DepartureStationInput.from(input);
    }

    public ArrivalStationInput readArrivalStationInput() {
        String input = Console.readLine();
        return ArrivalStationInput.from(input);
    }
}
