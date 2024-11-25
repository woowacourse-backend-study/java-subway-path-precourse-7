package subway;

import java.util.List;
import java.util.Scanner;
import subway.domain.Dijkstra;
import subway.domain.Factory;
import subway.domain.Path;
import subway.domain.PathPolicy;
import subway.domain.Policy;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.io.InputView;
import subway.io.OutputView;
import subway.io.Validate;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner, new Validate());
        OutputView outputView = new OutputView();
        Factory.init();

        while (true) {
            String input = inputView.inputMain();

            if (input.equals("Q")) {
                return;
            }

            String policyInput = inputView.inputPolicy();
            PathPolicy pathPolicy = null;
            if (policyInput.equals("1")) {
                pathPolicy = new PathPolicy(Policy.SHORT_DISTANCE);
            }
            if (policyInput.equals("2")) {
                pathPolicy = new PathPolicy(Policy.LOW_PRICE);

            }
            if (policyInput.equals("B")) {
                return;
            }

            List<String> inputs = inputView.inputStations();
            Station sourceStation = StationRepository.findByName(inputs.get(0));

            Dijkstra dijkstra = new Dijkstra(sourceStation, pathPolicy);
            dijkstra.calculatePath();
            String destinationName = inputs.get(1);
            Path shortestPath = dijkstra.getShortestPath(destinationName);
            outputView.outputPath(shortestPath);
        }
    }
}
