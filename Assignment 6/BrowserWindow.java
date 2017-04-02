// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.io.FileNotFoundException;
import java.util.Scanner;

// ------------------------------------------------------------------------------------------------------------------ //

public abstract class BrowserWindow implements IBrowserWindow {

    private Scanner keyboard = new Scanner(System.in);                         // Creates a Scanner object keyboard to take inputs from a user
    private SimpleMarkdownReader m = new SimpleMarkdownReader();               // Creates a SimpleMarkdownReader object

    BrowserWindow() {}
// ************************************** THE SCREEN/USER INTERFACE ************************************************* //

    void screen() {
        System.out.println("-------------------------------------");
        System.out.println("Enter a number to select an option");
        System.out.println("1. Search for pages");
        System.out.println("2. Visit a page");
        System.out.println("3. Exit the system (and lose all index data)");
        String choice = keyboard.next();
        // Eat up the rest of the line
        keyboard.nextLine();

        try {
            if (choice.equals("1")) {
                System.out.println("Enter your query:");
                String query = keyboard.nextLine();
                System.out.println("Search results: ");
                System.out.println(runQuery(query));
                screen();
            } else if (choice.equals("2")) {
                System.out.println("Which page (filename) do you want to visit?:");
                String filename = keyboard.next();
                System.out.println(visitPage(filename));
                screen();
            } else if (choice.equals("3"))
                System.out.println("Thanks for searching with us");
            else
                System.out.println("ERROR *** Unrecognized option " + choice + ". Try again");
        } catch (UnsupportedFileExn e) {
            System.out.println("ERROR *** Filetype not supported: " + e.filename);
            screen();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR *** No page found at address " + e);
            screen();
        }
    }

// ********************************** ADDING SITES TO THE ENGINE **************************************************** //

    // Parses the given file into a webpage
    public Webpage addSite(String locationName) throws UnsupportedFileExn, FileNotFoundException {

        Webpage newWP;

        if (locationName.endsWith(".md")) {
            System.out.println("Result of addSite :" + m.readPage(locationName));
            return (m.readPage(locationName));
        } else {
            throw new UnsupportedFileExn(locationName);
        }
    }
}
