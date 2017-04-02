// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.LinkedList;
import java.io.*;

// ------------------------------------------------------------------------------------------------------------------ //

interface ISearchEngine {
  // given query string, produce webpages that meet query
  public LinkedList<Webpage> runQuery(String query);

  // given a page location, return the corresponding page after updating queries
  public Webpage visitPage(String location) throws UnsupportedFileExn, FileNotFoundException;

  // produce the number of web pages known in the system
  // useful mainly for writing tests
  public int knownPageCount();

  // determine whether given query has been seen in the search engine
  // useful mainly for writing tests
  public boolean alreadySawQuery(String query);

  // update or add the rate info for the given sponsor
  public void updateSponsor(String sponsor, double rate) throws LowerRateException, InvalidRateException;

}