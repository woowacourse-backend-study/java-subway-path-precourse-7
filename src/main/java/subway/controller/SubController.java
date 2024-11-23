package subway.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import subway.domain.SubOption;
import subway.view.InputView;
import subway.view.OutputView;

public class SubController implements Controllable{

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<SubOption, Controllable> subControllers;

    public SubController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.subControllers = new EnumMap<>(SubOption.class);
        initializeServices();
    }

    @Override
    public void process() {
        SubOption option;
        do {
            outputView.printServiceOption();
            option = doLoop(() -> SubOption.from(inputView.enterSelectOption()));
            subControllers.get(option).process();
        } while (option.isBack());

    }

    private void initializeServices() {
        subControllers.put(SubOption.DISTANCE_ROUTE,new CalculateController(inputView, outputView, SubOption.DISTANCE_ROUTE));
        subControllers.put(SubOption.TIME_ROUTE,new CalculateController(inputView, outputView, SubOption.TIME_ROUTE));
        subControllers.put(SubOption.BACK,new ExitController());
    }

    private <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
