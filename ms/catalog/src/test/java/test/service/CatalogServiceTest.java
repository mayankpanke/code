package test.service;

import data.Catalog;
import data.Item;
import exception.CatalogException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.CatalogService;
import service.impl.StandardCatalogService;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class CatalogServiceTest {

    private CatalogService service;
    @Before
    public void setup() {
        service = new StandardCatalogService();
    }

    @After
    public void tearDown() {
        service = null;
    }

    @Test
    public void testCreateCatalog() {
        try {
            Catalog catalog = service.createCatalog("Catalog1");
            final Catalog expectedCatalog =  new Catalog("Catalog1");
            assertTrue(catalog.equals(expectedCatalog));
        } catch (CatalogException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testCreateCatalogEmptyName() {
        try {
            Catalog catalog = service.createCatalog("");
            fail("fail excepted when empty name");
        } catch (CatalogException e) {
            assertTrue(e.getMessage().equals("EmptyName"));
        }
    }

    @Test
    public void testCreateCatalogNullName() {
        try {
            Catalog catalog = service.createCatalog(null);
            fail("fail excepted when empty name");
        } catch (CatalogException e) {
            assertTrue(e.getMessage().equals("EmptyName"));
        }
    }

    @Test
    public void testaddItemToCatalog() {
        try {
            Catalog catalog = service.createCatalog("Catalog1");
            boolean added = service.addToCatalog(catalog.getName(), new Item("Item1", "description"));
            assertTrue(added);
        } catch (CatalogException e) {
            fail("fail excepted");
        }
    }

}