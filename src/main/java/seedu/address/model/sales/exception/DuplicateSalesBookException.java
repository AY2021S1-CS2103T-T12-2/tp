package seedu.address.model.sales.exception;

public class DuplicateSalesBookException extends RuntimeException {
    public DuplicateSalesBookException() {
        super("Operation would result in duplicate sales book entry.");
    }
}
