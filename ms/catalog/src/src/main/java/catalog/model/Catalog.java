package catalog.model;

import java.util.Collection;
import java.util.HashSet;

public class Catalog {

    private String catalogName;

    public Catalog(String catalogName) {
        this.catalogName = catalogName;
        this.allItems = new HashSet<>();
    }

    private Collection<Item> allItems;

    public String getName() {
        return catalogName;
    }

    public boolean addItem(Item item) {
        return allItems.add(item);
    }

    public Collection<Item> getAllItems() {
        return allItems;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Catalog)) {
            return  false;
        } else if(this.getName().equals(((Catalog)obj).getName())) {
            return true;
        }
        return false;
    }
}
