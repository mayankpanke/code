package service.impl;

import data.Catalog;
import data.Item;
import exception.CatalogException;
import exception.CatalogNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import service.CatalogService;

@Service
public class StandardCatalogService implements CatalogService {

    @Override
    public Catalog createCatalog(final String catalogName) throws CatalogException {
        if(catalogName == null || catalogName.isEmpty())
            throw new CatalogException("EmptyName");
        Catalog catalog = new Catalog(catalogName);
        return catalog;
    }

    @Override
    public boolean addToCatalog(final String catalogName, final Item item) throws CatalogNotFoundException {
        Catalog catalog = getCatalog(catalogName);
        if(catalog == null) {
            throw new CatalogNotFoundException();
        }
       return catalog.addItem(item);

    }

    private Catalog getCatalog(String catalogName) {
        //get this from local cache / database .. dummy implementation as of now.
        return new Catalog(catalogName);
    }

    @Bean @Primary
    public CatalogService newCatalogService() {
        return new StandardCatalogService();
    }
}
