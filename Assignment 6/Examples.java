// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.io.FileNotFoundException;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

// ------------------------------------------------------------------------------------------------------------------ //

public class Examples {

    SearchEngine s;                          // Instructor SearchEngine object
    SearchEngine studentMachine;             // Student SearchEngine object

    // local method to add a page to a search engine.  Created a
    //   helper so that we can isolate the exception handling here,
    //   rather than clutter up each test case with the exceptions
    private void addPage(SearchEngine s, String p) {
        try {
            s.visitPage(p);
        } catch (FileNotFoundException e) {
            fail("Aborting Example setup -- file not found: " + e);
        } catch (UnsupportedFileExn e) {
            fail("Aborting Examples setup -- unsupported file extension: " + e);
        }
    }

    // Student version for local method to add a page to a search engine.
    private void studentAddPage(SearchEngine s, String p) {
        try {
            studentMachine.visitPage(p);
        } catch (FileNotFoundException e) {
            fail("Aborting Example setup -- file not found: " + e);
        } catch (UnsupportedFileExn e) {
            fail("Aborting Examples setup -- unsupported file extension: " + e);
        }
    }

    public Examples() {
        try {
            // set up all of your search engines with pages here
            // rather than in the individual tests (or you will have
            // to copy the exceptions code into the test classes)
            s = new SearchEngine(new LinkedList<String>());
            addPage(s, "src/PageFiles/goats.md");
            addPage(s, "src/PageFiles/aboutWPI.md");
        } catch (FileNotFoundException e) {
            System.out.println("Aborting Example setup -- file not found: " + e);
        } catch (UnsupportedFileExn e) {
            System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
        }

        try {
            studentMachine = new SearchEngine(new LinkedList<String>());
            studentAddPage(studentMachine, "src/PageFiles/goats.md");              // Adds goats.md to search engine
            studentAddPage(studentMachine, "src/PageFiles/aboutWPI.md");           // Adds aboutWPI.md to search engine
            studentAddPage(studentMachine, "src/PageFiles/worcester.md");          // Adds worcester.md to search engine
        } catch (FileNotFoundException e) {
            System.out.println("Aborting Example setup -- file not found: " + e);
        } catch (UnsupportedFileExn e) {
            System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
        }
        try {
            studentMachine.updateSponsor("WPI", 0.05);
        } catch (InvalidRateException e) {
            System.out.println("Aborting Example setup -- Invalid Rate" + e);
        } catch (LowerRateException e) {
            System.out.println("Aborting Example setup -- Rate too low" + e);
        }
    }

    // Tests the runQuery method
    @Test
    public void testGoatsQuery() {
        assertEquals(s.runQuery("goat").size(), 2);
    }
    // Tests the runQuery method and adding another page and query on the method
    @Test
    public void testWPIQuery() {
        System.out.println("Run Query for WPI :" + s.runQuery("WPI"));
        assertEquals(s.runQuery("WPI").size(), 1);
        addPage(s, "src/PageFiles/worcester.md");
        assertEquals(s.runQuery("WPI").size(), 2);
    }

    // Tests the visitPage method
    @Test
    public void testVisitPage() throws UnsupportedFileExn, FileNotFoundException {
        assertFalse(s.visitPage("src/PageFiles/aboutWPI.md") == s.visitPage("src/PageFiles/worcester.md"));
    }

    // Tests the knownPageCount method
    @Test
    public void testKnownPageCount() {
        assertTrue(studentMachine.knownPageCount() == 3);
    }

    // Tests the alreadySawQuery method
    @Test
    public void testAlreadySawQuery() {
        assertFalse(studentMachine.alreadySawQuery("WPI"));
    }

    // Tests getSponsoredRate
    @Test
    public void testGetSponsoredRate() {
        assertEquals(studentMachine.s.getSponsoredRate("aboutWPI.md"), 0.05, 0.01);
    }
    // Tests the order of the output for runQuery
    @Test
    public void testOrderRunQuery() throws UnsupportedFileExn, FileNotFoundException {
        assertEquals(s.runQuery("WPI").getFirst(), s.visitPage("src/PageFiles/aboutWPI.md"));
    }

// -------------------------------------------- Exception Test Cases ------------------------------------------------ //

    // Problem 2.4.2 - Step 4: Testing Exceptions

    // Tests the InvalidRateException
    @Test (expected = InvalidRateException.class)
    public void invalidRateTest1() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", 2.0);
    }

    // Tests update sponsor with no exception expected
    @Test
    public void validRateTest1() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", 0.05);
    }
}
