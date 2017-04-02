// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.HashMap;

// ------------------------------------------------------------------------------------------------------------------ //

public class Sponsor {

// Problem 2.3 - Step 3: Add Data Structures for Sponsors

    // Hashmap that stores name of Sponsor and rate the Sponsor will pay per page
    private HashMap<String, Double> sponsorInfo = new HashMap<>();

    // Getter for sponsorInfo
    public HashMap<String, Double> getSponsorInfo() { return this.sponsorInfo; }

    // Problem 2.5 - Step 5: Modify Page Ranking based on Sponsorship

    // Takes in a Webpage URL and returns a double of how much sponsors are paying for this page.
    public double getSponsoredRate(String someURL) {

        for (String s : sponsorInfo.keySet()) {

            if (someURL.contains(s)) {               // Returns Sponsor rate if URL matches a page
                return sponsorInfo.get(s);
            }
        }
        return 0;                                    // Returns zero if input URL doesn't match any pages
    }
}
