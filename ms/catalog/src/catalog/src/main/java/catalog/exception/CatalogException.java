package catalog.exception;

/**
 * Created by vagrant on 5/1/17.
 */
public class CatalogException extends Exception {

    private final String message;

    public CatalogException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
