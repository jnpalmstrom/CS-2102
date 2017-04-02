import java.util.LinkedList;

class Webpage {
  String url;
  String title;  
  String body;   
  LinkedList<String> referencedURLs;
  
  // The constructor converts title and body to lowercase, to ease
  //  other computations later
  Webpage(String locator, String title, String body,
          LinkedList<String> referencedURLs) {
    this.url = locator;
    this.title = title.toLowerCase();
    this.body = body.toLowerCase();
    this.referencedURLs = referencedURLs;
  }
}