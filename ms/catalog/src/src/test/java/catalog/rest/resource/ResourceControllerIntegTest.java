package catalog.rest.resource;

import catalog.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = RANDOM_PORT)
public class ResourceControllerIntegTest {

    @Autowired
    private CatalogResource controller;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void createCatalog() throws Exception {
        mockMvc.perform(post("/catalogs").param("catalogName", "Catalog1"))
                .andExpect(status().isCreated());
    }

    @Test
    public void createAndValidateCatalogResponse() throws Exception {
        String expectedBody = "{\"allItems\":[],\"name\":\"Catalog1\"}";
        mockMvc.perform(post("/catalogs").param("catalogName", "Catalog1"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(expectedBody));
    }

    @Test
    public void createCatalogFail() throws Exception {
        mockMvc.perform(post("/catalogs").param("catalogName", ""))
                .andExpect(status().isInternalServerError());
    }

}