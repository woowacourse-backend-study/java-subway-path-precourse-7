package subway.io;

public class Validate {

    public boolean validateInputMain(String input) {
        return input.equals("1") || input.equals("Q");
    }

    public boolean validateInputStations(String sourceName, String destinationName) {
        return !(sourceName.equals(destinationName));
    }

    public boolean validateInputPolicy(String policyInput) {
        return (policyInput.equals("B") || policyInput.equals("1") || policyInput.equals("2"));
    }
}
