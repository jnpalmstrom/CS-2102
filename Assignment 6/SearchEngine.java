// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong


// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.LinkedList;
import java.util.Arrays;
import java.io.*;
import java.util.Collections;

// ------------------------------------------------------------------------------------------------------------------ //

public class SearchEngine extends BrowserWindow implements ISearchEngine {

    Cache c = new Cache();
    Sponsor s = new Sponsor();

    // Stores the matched pages when running a query.
    public LinkedList<Webpage> pages = new LinkedList<Webpage>();


// ------------------------------------------ Constructor ----------------------------------------------------------- //

    // Constructor takes in a LinkedList of String and adds the Strings to pages.
    public SearchEngine(LinkedList<String> initPages) throws FileNotFoundException, UnsupportedFileExn {

        for (String pageLoc : initPages) {
            pages.add(addSite(pageLoc));
        }
    }

// *************************** THE SEARCH ENGINE METHODS YOU NEED TO PROVIDE **************************************** //

    // Problem 2.5.1 - Step 5: Use SponsoredRates in runQuery

    // Given a query string and produces a LinkedList of webpages that meet the query
    public LinkedList<Webpage> runQuery(String query) {

        String strippedQuery = stripFillers(query).toLowerCase();     // Removes junk words and sets query to lowercase
        LinkedList<Webpage> searchResults = new LinkedList<>();       // LinkedList to store webpages that match query

        if (c.getStoredPages().containsKey(strippedQuery)) {
            return c.getStoredPages().get(strippedQuery);
        } else

            for (Webpage aPage : c.getMatchedPages().values()) {

                if ((aPage.getBody().contains(strippedQuery)) || (aPage.getTitle().contains(strippedQuery))) {
                    searchResults.add(aPage);
                }
            }

        c.getStoredPages().put(strippedQuery, searchResults);


        // Problem 2.5.1 - Use SponsoredRates in runQuery

        // Resets all pages associated with strippedQuery ranks to zero
        for (int x = 0; x < c.getStoredPages().get(strippedQuery).size(); x++) {
            c.getStoredPages().get(strippedQuery).get(x).rank = 0;
        }

        c.addResult(s);                                                   // Runs addResult

        // Problem 2.7 - Include Link Credits in runQuery

        c.distributedCredits(s);                                          // Runs distributedCredits
        rankingPages(c.getStoredPages().get(strippedQuery));              // Sorts Pages associated with the Query
        System.out.println("New runQuery: " + c.getStoredPages().get(strippedQuery));
        return c.getStoredPages().get(strippedQuery);
    }

    // Given a page location, returns the corresponding page after updating queries
    public Webpage visitPage(String location) throws UnsupportedFileExn, FileNotFoundException {

        Webpage returnedPage = c.getMatchedPages().get(location);
        LinkedList<Webpage> visitedPages = new LinkedList<>();

        if (returnedPage == null) {

            returnedPage = this.addSite(location);
            c.getMatchedPages().put(location, returnedPage);

            for (String oneQuery : c.getStoredPages().keySet()) {

                visitedPages = c.getStoredPages().get(oneQuery);

                if ((returnedPage.getBody().contains(oneQuery)) || (returnedPage.getTitle().contains(oneQuery))) {

                    visitedPages.add(returnedPage);
                    c.getStoredPages().put(oneQuery, visitedPages);
                }
            }
        }
        System.out.println("Returned Page : " + returnedPage);
        return returnedPage;
    }

    // Produce the number of web pages known in the system
    public int knownPageCount() {
        return c.getMatchedPages().size();
    }

    // Determine whether given query has been seen in the search engine
    public boolean alreadySawQuery(String query) {
        return false;
    }

// *********************************** REMOVING FILLER WORDS FROM QUERIES ******************************************* //

    // Creates a Linked Lists of words considered "Filler".
    private LinkedList<String> fillerWords =
            new LinkedList<String>(Arrays.asList("a", "an", "the", "of", "on", "in",
                    "to", "by", "about", "how", "is",
                    "what", "when"));

    // Removes the filler words from a string
    private String stripFillers(String query) {
        String[] wordArray = query.toLowerCase().split(" ");
        String resultStr = "";
        for (int i = 0; i < wordArray.length; i++) {
            if (!(fillerWords.contains(wordArray[i])))
                resultStr = resultStr + wordArray[i];
        }
        return resultStr;
    }

    // Problem 2.2 - Step 2: Sort pages by their ranks
    public LinkedList<Webpage> rankingPages(LinkedList<Webpage> setOfPages) {

        LinkedList<Webpage> decreasingPages = new LinkedList<>();    // Initializes new LinkedList for storing pages
        Collections.sort(setOfPages);                                // Sorts the inputted list (in decreasing order by rank)

        for (Webpage w : setOfPages) {                               // Adds sorted Webpages to decreasingPages
            decreasingPages.add(w);
        }

        return decreasingPages;
    }

    // Problem 2.3 - Step 3: Add Data Structures for Sponsors

    // Takes a sponsor name and a new rate and sets the sponsor to have the given rate
    public void updateSponsor(String name, double rate) throws LowerRateException, InvalidRateException {

            if (s.getSponsorInfo().containsKey(name)) {                        // Checks if input name is in Sponsor Hashmap
                if (rate < s.getSponsorInfo().get(name)) {                     // Checks for Exception
                    throw new LowerRateException();
                }
                s.getSponsorInfo().replace(name, rate);                        // Replaces original rate for inputted name key with inputted rate
            } else
                if ((rate < 0) || (rate > 0.1)) {                         // Checks for Exception
                    throw new InvalidRateException();
                }
                s.getSponsorInfo().put(name, rate);                            // Adds inputted name and rate to Sponsor Hashmap
    }
}
