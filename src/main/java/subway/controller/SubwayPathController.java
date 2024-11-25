package subway.controller;

import java.util.function.Supplier;
import subway.dto.PathRequestDto;
import subway.dto.PathResponseDto;
import subway.service.PathStandard;
import subway.service.SubwayPathService;
import subway.view.InputView;
import subway.view.MainOption;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayPathController {
    private final SubwayPathService subwayPathService;
    private final InputView inputView;

    public SubwayPathController(SubwayPathService subwayPathService, Scanner scanner) {
        this.subwayPathService = subwayPathService;
        this.inputView = new InputView(scanner);
    }

    public void run() {
        MainOption mainOption;
        do {
            OutputView.printMainFeature();
            mainOption = inputWithRetry(inputView::inputMainOption);
            if (mainOption.isPathGet()) {
                pathGet();
            }
        } while (!mainOption.isQuit());
    }

    private void pathGet() {
        OutputView.printPathStandard();
        PathResponseDto pathResponseDto = subwayPathService.getShortestPath(createRequestDto());
        OutputView.printPathResult(pathResponseDto);
    }

    private PathRequestDto createRequestDto() {
        PathStandard pathStandard = inputWithRetry(inputView::inputPathStandard);
        String startStation = inputWithRetry(inputView::inputStartStation);
        String endStation = inputWithRetry(inputView::inputEndStation);
        return new PathRequestDto(pathStandard, startStation, endStation);
    }

    private <T> T inputWithRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printExceptionMessage(e);
            }
        }
    }

    private void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}