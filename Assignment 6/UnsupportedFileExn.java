// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong


// -------------------------------------------- Imports ------------------------------------------------------------- //



// ------------------------------------------------------------------------------------------------------------------ //

class UnsupportedFileExn extends Exception {
  String filename;
  
  UnsupportedFileExn(String filename){
    this.filename = filename;
  }
}