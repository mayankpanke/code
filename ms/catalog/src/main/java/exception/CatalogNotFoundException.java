package exception;

/**
 * Created by vagrant on 5/1/17.
 */
public class CatalogNotFoundException extends CatalogException {

    public CatalogNotFoundException() {
        super("Catalog not found");
    }
}
