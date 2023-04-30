//public class DictionaryChain{
//  public LinkedList[] dict;
//  public int count;
//  private static final double LOAD_FACTOR = 2.0;
//  
//  //constructor
//  public DictionaryChain(int size){
//    size = getNextPrime(size);
//    dict = new LinkedList [size];
//    count = 0;
//  }
//  
//  //insert
//  public void insert(String newItem){
//    newItem = newItem.toLowerCase();
//    if(!search(newItem)){
//      ////System.out.println(newItem + " not found, inserting...");
//      if(count >= dict.length*LOAD_FACTOR){
//        ////System.out.println("Enlarging dict...");
//        enlargeDict();
//        ////System.out.println("Done...");
//      }
//      int key = getHashValue(newItem,dict.length);
//      //System.out.println("key is " + key);
//      if(dict[key] == null){
//        ////System.out.println("Making new Linked List");
//        dict[key] = new LinkedList();
//        ////System.out.println("Done");
//      }
//      dict[key].add(newItem);
//      
//      count++;
//    }
//  }
//  
//  //search
//  public boolean search(String lookup){
//    lookup = lookup.toLowerCase();
//    boolean found = false;
//    //////System.out.println("Checking...");
//    int key = getHashValue(lookup,dict.length);
//    //////System.out.println("hashvalue is: " + key);
//    if(dict[key] != null)
//      found = dict[key].search(lookup);
//    //////System.out.println("found? " + found);
//    return found;
//  }
//  
//  //toString
//  public String toString(){
//    String s = "Dictionary: ";
//    for(LinkedList ll: dict){
//      if(ll != null)
//        s+= ll + "\n";
//    }
//    return s;
//  }
//  
//  //getSize
//  public int getSize(){
//    return count;
//  }
//  
//  /******************************HELPER METHODS***********************************/
//  private boolean isPrime(int p){
//    boolean prime = true;
//    for(int i = 2; (i*i <= p)&& prime; i++){
//      if(p%i == 0)
//        prime = false;
//    }
//    return prime;
//  }
//  
//  private int getNextPrime(int p){
//    int nextPrime = p;
//    while(!isPrime(nextPrime)){
//      nextPrime++;
//    }
//    return nextPrime;
//  }
//  
//  public static int getHashValue(String in, int hashArraySize){
//      int hashValue = 0;
//      int a = 27;
//      
//      for(char c: in.toCharArray()){
//         hashValue = (hashValue*a) % hashArraySize;
//         hashValue += (((int) c ) - 97) % hashArraySize;
//      }
//      return hashValue%hashArraySize;
//  }
//  
//  private void enlargeDict(){
//    //System.out.println("Enlarging...");
//    LinkedList[] newDict = new LinkedList[getNextPrime(dict.length+1)];
//    int key;
//    int stepSize;
//    for(int i = 0; i < dict.length; i++){
//      if(dict[i] != null){
//        Node curr = dict[i].top;
//        while(curr != null){
//          key = getHashValue(curr.data,newDict.length);
//          if(newDict[key] == null)
//            newDict[key] = new LinkedList();
//          newDict[key].add(curr.data);
//          curr = curr.next;
//        }
//      }
//    }
//    dict = newDict;
//    //System.out.println("Done");
//  }
//}
//
//class LinkedList{
//  public Node top;
//  
//  public LinkedList(){
//    top = null;
//  }
//  
//  public void add(String i){
//    if(isEmpty())
//      top = new Node(i,null);
//    else{
//      Node newNode = new Node(i,top);
//      top = newNode;
//    }
//  }
//  
//  public boolean search(String s){
//    boolean found = false;
//    Node curr = top;
//    while(curr != null && !found){
//      if(curr.data.equals(s))
//        found = true;
//      curr = curr.next;
//    }
//    return found;
//  }
//  
//  
//  public boolean isEmpty(){
//    return top == null;
//  }
//  
//  public boolean isFull(){return false;}
//  
//  public String toString(){
//    String s = "";
//    Node curr = top;
//    while(curr != null){
//      s += "\n" + curr.data ;
//      curr = curr.next;
//    }
//    return s ;
//  }
//}
//
//class Node{
//  public String data;
//  public Node next;
//  
//  //constructor
//  public Node(String data, Node next){
//    this.data = data;
//    this.next = next;
//  }
//}