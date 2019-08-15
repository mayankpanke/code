package rest.resource;


import data.Catalog;
import exception.CatalogException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CatalogService;

@RestController
@RequestMapping("/catalogs")

public class CatalogResource {
    @Autowired
    private CatalogService service;

    @PostMapping
    public ResponseEntity<Catalog> createCatalog(@RequestParam() String catalogName) {
        try {
            Catalog catalog = service.createCatalog(catalogName);
            return new ResponseEntity<Catalog>(catalog, HttpStatus.CREATED);
        } catch (CatalogException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
