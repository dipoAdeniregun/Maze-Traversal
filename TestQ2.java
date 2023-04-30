public class TestQ2{
  public static void main(String[] args){
    DictionaryOpen d1 = new DictionaryOpen(3);
    System.out.println("Creating new dictionary...");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding new word: bat...");
    d1.insert("bat");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding new word: cat...");
    d1.insert("cat");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding new word: bad...");
    d1.insert("bad");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding new word: ant...");
    d1.insert("ant");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding already existing word: ant...");
    d1.insert("ant");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding new word: fat...");
    d1.insert("fat");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding new word: vat...");
    d1.insert("vat");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding new word: gnat...");
    d1.insert("gnat");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Adding new word: pat...");
    d1.insert("pat");
    System.out.println(d1 + "\n");
    System.out.println("The dictionary has "+d1.getSize()+ " words");
    
    System.out.println("Searching for pat...");
    System.out.println("Was pat found? " + d1.search("pat"));
    
    System.out.println("Searching for bat...");
    System.out.println("Was bat found? " + d1.search("bat"));
    
    System.out.println("Searching for vat...");
    System.out.println("Was pat found? " + d1.search("vat"));
    
    System.out.println("Searching for xylophone...");
    System.out.println("Was pat found? " + d1.search("xylophone"));
    
    System.out.println("Searching for \"\"...");
    System.out.println("Was pat found? " + d1.search(""));
  }
}