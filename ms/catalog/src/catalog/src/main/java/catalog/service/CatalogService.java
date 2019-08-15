package catalog.service;

import catalog.data.Catalog;
import catalog.data.Item;
import catalog.exception.CatalogException;

public interface CatalogService {

    Catalog createCatalog(final String catalogName) throws CatalogException;

    boolean addToCatalog(final String catalogName, final Item item) throws CatalogException;

}
