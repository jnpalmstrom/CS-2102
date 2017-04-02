// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.LinkedList;
import java.io.*;

// ------------------------------------------------------------------------------------------------------------------ //


interface IBrowserWindow {

    public LinkedList<Webpage> runQuery (String query);

    public Webpage visitPage (String location) throws UnsupportedFileExn, FileNotFoundException;

}
