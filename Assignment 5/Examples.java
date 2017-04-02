/*
 * If you are looking at this file before Thurs/Fri, the try/catch
 * statements won't make sense (unless you already know exceptions).
 * By Friday, we will cover those.  In the meantime, you can write
 * tests by creating your search engine classes in the Examples
 * constructor, as indicated by the comments.
 */

import java.util.LinkedList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

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
    }

    // Tests the runQuery method
    @Test
    public void testGoatsQuery() {
        assertEquals(s.runQuery("goat").size(), 2);
    }
    // Tests the runQuery method and adding another page and query on the method
    @Test
    public void testWPIQuery() {
        assertEquals(s.runQuery("WPI").size(), 1);
        addPage(s, "src/PageFiles/worcester.md");
        assertEquals(s.runQuery("WPI").size(), 2);
    }
    // Tests the visitPage method
    @Test
    public void testVisitPage() throws UnsupportedFileExn, FileNotFoundException {
        assertEquals(studentMachine.visitPage("src/PageFiles/goats.md"), studentMachine.c.getMatchedPages().get("src/PageFiles/goats.md"));
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
}
