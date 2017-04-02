// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.LinkedList;
import java.io.*;

// ------------------------------------------------------------------------------------------------------------------ //

interface IBrowserWindow {

    // Given a query string, runQuery produces webpages that meet query
    public LinkedList<Webpage> runQuery (String query);

    // Given a page location, visitPage returns corresponding page after updating queries
    public Webpage visitPage (String location) throws UnsupportedFileExn, FileNotFoundException;

}
