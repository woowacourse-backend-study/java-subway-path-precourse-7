package subway.infrastructure;

public class ErrorException extends IllegalArgumentException {
    public ErrorException(String message) {
        super(String.format("[ERROR] %s", message));
    }
}
