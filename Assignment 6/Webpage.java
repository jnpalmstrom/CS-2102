// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong


// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.LinkedList;

// ------------------------------------------------------------------------------------------------------------------ //

class Webpage implements Comparable<Webpage> {

    public String url;
    private String title;
    private String body;
    private LinkedList<String> referencedURLs;

    // Problem 2.1 - Step 1: Add a rank field to Webpages
    public double rank;

    // The constructor converts title and body to lowercase, to ease
    // other computations later
    Webpage(String locator, String title, String body,
            LinkedList<String> referencedURLs) {
        this.url = locator;
        this.title = title.toLowerCase();
        this.body = body.toLowerCase();
        this.referencedURLs = referencedURLs;
        this.rank = 0;                          // Sets rank to zero
    }

    // Getter method for title field
    public String getTitle() {
        return this.title;
    }

    // Getter method for body field
    public String getBody() {
        return this.body;
    }

    //Getter method for ReferencedURLs field
    public LinkedList<String> getReferencedURLs() {
        return this.referencedURLs;
    }

    @Override
    public int compareTo(Webpage o) {
        return 0;
    }

}