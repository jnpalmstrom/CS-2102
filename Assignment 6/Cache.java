// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.LinkedList;
import java.util.HashMap;

// ------------------------------------------------------------------------------------------------------------------ //
public class Cache {


    // Hashmap that stores the query and the list of webpages associated with the query
    private HashMap<String, LinkedList<Webpage>> storedPages = new HashMap<String, LinkedList<Webpage>>();

    // Hashmap that stores the location of the webpage and the webpage associated with the location
    private HashMap<String, Webpage> matchedPages = new HashMap<String, Webpage>();

    // Getter for storedPages Hashmap
    public HashMap<String, LinkedList<Webpage>> getStoredPages() {
        return this.storedPages;
    }

    // Getter for matchedPages Hashmap
    public HashMap<String, Webpage> getMatchedPages() {
        return this.matchedPages;
    }

    public void addResult(Sponsor s) {

        for (Webpage w : matchedPages.values()) {

            w.rank = w.rank + s.getSponsoredRate(w.url);
        }
    }

    public void distributedCredits(Sponsor s) {

        int count = 0;

        for (Webpage w : matchedPages.values()) {

            for (String url : w.getReferencedURLs()) {

                if (url != w.url) {
                    count = count + 1;
                } else if (url == null) {
                    matchedPages.get(url).rank =  matchedPages.get(url).rank + (1 / count);
                }
            }
        }
    }
}
