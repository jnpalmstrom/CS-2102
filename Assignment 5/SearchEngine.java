// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

// ------------------------------------------------------------------------------------------------------------------ //

public class SearchEngine extends BrowserWindow implements ISearchEngine {

    public Cache c = new Cache();

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


// Problem 2.2 - Step 2: Run Queries (Core and Full)

    // Given a query string and produces a LinkedList of webpages that meet the query
    public LinkedList<Webpage> runQuery(String query) {

        String strippedQuery = stripFillers(query).toLowerCase();     // Removes junk words and sets query to lowercase
        LinkedList<Webpage> searchResults = new LinkedList<>();       // LinkedList to store webpages that match query

        if (c.getStoredPages().containsKey(strippedQuery)) {
            return c.getStoredPages().get(strippedQuery);
        } else

            for (Webpage aPage : c.getMatchedPages().values()) {

                if ((aPage.body.contains(strippedQuery)) || (aPage.title.contains(strippedQuery))) {
                    searchResults.add(aPage);
                }
            }

        c.getStoredPages().put(strippedQuery, searchResults);
        return c.getStoredPages().get(strippedQuery);
    }

// Problem 2.3 - Step 3: Visit Pages (Core and Full)

    // Given a page location, returns the corresponding page after updating queries
    public Webpage visitPage(String location) throws UnsupportedFileExn, FileNotFoundException {

        Webpage returnedPage = c.getMatchedPages().get(location);
        LinkedList<Webpage> visitedPages = new LinkedList<>();

        if (returnedPage == null) {

            returnedPage = this.addSite(location);
            c.getMatchedPages().put(location, returnedPage);

            for (String oneQuery : c.getStoredPages().keySet()) {

                visitedPages = c.getStoredPages().get(oneQuery);

                if ((returnedPage.body.contains(oneQuery)) || (returnedPage.title.contains(oneQuery))) {

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
}
