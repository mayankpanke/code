package rest.resource;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class ResourceController {

    @PostMapping
    public void addToCatalog() {

    }
}
