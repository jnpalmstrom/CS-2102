// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.LinkedList;
import java.util.HashMap;

// ------------------------------------------------------------------------------------------------------------------ //
public class Cache {

    // Problem 2.1 - Step 1: Store Previous Search Results (Core and Full)
    // Create a data structure that stores the webpages that match the individual queries.

    // Hashmap that stores the query and the list of webpages associated with the query
    private HashMap<String, LinkedList<Webpage>> storedPages = new HashMap<String, LinkedList<Webpage>>();

    // Hashmap that stores the location of the webpage and the webpage associated with the location
    private HashMap<String, Webpage> matchedPages = new HashMap<String, Webpage>();

    public HashMap<String, LinkedList<Webpage>> getStoredPages() {
        return this.storedPages;
    }
    public HashMap<String, Webpage> getMatchedPages() {
        return this.matchedPages;
    }
}
