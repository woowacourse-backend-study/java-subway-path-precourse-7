package subway;

import subway.dto.ArrivalStationInput;
import subway.dto.CriteriaFunctionInput;
import subway.dto.DepartureStationInput;
import subway.dto.MainFunctionInput;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();

        outputView.printMainPrompt();

        outputView.printUserFunctionInputPrompt();

        InputView inputView = new InputView();
        MainFunctionInput userFunctionInput = inputView.readMainFunctionInput();
        System.out.println();

        outputView.printFunctionCriteriaInputPrompt();
        CriteriaFunctionInput criteriaFunctionInput = inputView.readCriteriaFunctionInput();

        outputView.printDepartureStationInputPrompt();
        DepartureStationInput departureStationInput = inputView.readDepartureStationInput();

        outputView.printArrivalStationInputPrompt();
        ArrivalStationInput arrivalStationInput = inputView.readArrivalStationInput();
    }
}
