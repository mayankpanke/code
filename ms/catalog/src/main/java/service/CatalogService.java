package service;

import data.Catalog;
import data.Item;
import exception.CatalogException;
import org.springframework.stereotype.Service;

@Service
public interface CatalogService {

    public Catalog createCatalog(final String catalogName) throws CatalogException;

    public boolean addToCatalog(final String catalogName, final Item item) throws CatalogException;

}
