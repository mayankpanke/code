package catalog.service;

import catalog.model.Catalog;
import catalog.model.Item;
import catalog.exception.CatalogException;

public interface CatalogService {

    Catalog createCatalog(final String catalogName) throws CatalogException;

    boolean addToCatalog(final String catalogName, final Item item) throws CatalogException;

}
