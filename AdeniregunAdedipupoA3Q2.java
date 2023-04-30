//==============================================================
// A3Q2template.java
//
// COMP 2140 SUMMER 2021 D01
// ASSIGNMENT 3 QUESTION 2
// PROVIDED TEMPLATE
//
// PURPOSE: Compare the performace of three dictionaries (ordered
//          array, open addressing hash table, separate chaining
//          hash table).
//==============================================================

import java.io.*;
import java.util.*;

//==========================================================
// A3Q2template class (main) --- MODIFY TO INCLUDE YOUR NAME BUT OTHERWISE DO NOT CHANGE THIS CLASS
//
// PURPOSE: Compare performance of three dictionaries. Given
//          a text file, time how long it takes to fill each
//          dictionary, one word at a time. Time how long it
//          takes to search each dictionary for a given set
//          of words.
//==========================================================

public class AdeniregunAdedipupoA3Q2 {

    public static void main(String[] args){

  String inputFile = "GreatExpectations.txt";
  String searchFile = "A3Q2TestWords.txt";

  DictionaryOrdered allWordsOrdered; //complete dictionary, using an ordered array
  DictionaryOpen allWordsOpen; //complete dictionary, using open addressing
  DictionaryChain allWordsChain; //complete dictionary, using separate chaining

  long startTime, endTime, elapsedTime;

  //Fill the dictionaries
  System.out.println("\nFilling ordered array dictionary...");
  startTime = System.nanoTime();
  allWordsOrdered = new DictionaryOrdered(100);
  buildOrdered(allWordsOrdered, inputFile);
  endTime = System.nanoTime();
  elapsedTime = endTime - startTime;
  System.out.println("The time to fill the ordered array dictionary with " + allWordsOrdered.getSize() + " words was: " + elapsedTime + " ns.");

  System.out.println("\nFilling open addressing dictionary...");
  allWordsOpen = new DictionaryOpen(100);
  startTime = System.nanoTime();
  buildOpen(allWordsOpen, inputFile);
  endTime = System.nanoTime();
  elapsedTime = endTime - startTime;
  System.out.println("The time to fill the open addressing dictionary with " + allWordsOpen.getSize() + " words was: " + elapsedTime + " ns.");

  System.out.println("\nFilling separate chaining dictionary...");
  allWordsChain = new DictionaryChain(100);
  startTime = System.nanoTime();
  buildChain(allWordsChain, inputFile);
  endTime = System.nanoTime();
  elapsedTime = endTime - startTime;
  System.out.println("The time to fill the separate chaining dictionary with " + allWordsChain.getSize() + " words was: " + elapsedTime + " ns.");

  //Search the dictionaries
  System.out.println("\nSearching ordered array dictionary...");
  startTime = System.nanoTime();
  searchOrdered(allWordsOrdered, searchFile);
  endTime = System.nanoTime();
  elapsedTime = endTime - startTime;
  System.out.println("The time to search the ordered array dictionary was: " + elapsedTime + " ns.");

  System.out.println("\nSearching open addressing dictionary...");
  startTime = System.nanoTime();
  searchOpen(allWordsOpen, searchFile);
  endTime = System.nanoTime();
  elapsedTime = endTime - startTime;
  System.out.println("The time to search the open addressing dictionary was: " + elapsedTime + " ns.");

  System.out.println("\nSearching separate chaining dictionary...");
  startTime = System.nanoTime();
  searchChain(allWordsChain, searchFile);
  endTime = System.nanoTime();
  elapsedTime = endTime - startTime;
  System.out.println("The time to search the separate chaining dictionary was: " + elapsedTime + " ns.");

  System.out.println("\nEnd of Processing.");
    }//end main

    //==========================================================
    // buildOrdered
    //
    // PURPOSE: Fill the given dictionary with the given text.
    //
    // PARAMETERS:
    //   allWordsOrdered - the dictionary to be filled
    //   inputFile - the file containing words to add to dictionary
    //
    // RETURNS:
    //   none
    //==========================================================
    static void buildOrdered(DictionaryOrdered allWordsOrdered, String inputFile){
  String temp;
  String[] words;

  try{
   BufferedReader buff = new BufferedReader(new FileReader(new File(inputFile)));

   temp = buff.readLine();
      while(temp != null){
       words = temp.split("[^a-zA-Z’]+");

    for (int i=0; i<words.length; i++)
         allWordsOrdered.insert(words[i]);

    temp = buff.readLine();
      }

  }//end try
  catch (IOException e){
      System.out.println("File I/O Error: " + inputFile);
  }

    }//end buildOrdered

    //==========================================================
    // buildOpen
    //
    // PURPOSE: Fill the given dictionary with the given text.
    //
    // PARAMETERS:
    //   allWordsOpen - the dictionary to be filled
    //   inputFile - the file containing words to add to dictionary
    //
    // RETURNS:
    //   none
    //==========================================================
    static void buildOpen(DictionaryOpen allWordsOpen, String inputFile){
  String temp;
  String[] words;

  try{
   BufferedReader buff = new BufferedReader(new FileReader(new File(inputFile)));

   temp = buff.readLine();
      while(temp != null){
       words = temp.split("[^a-zA-Z’]+");

    for (int i=0; i<words.length; i++)
         allWordsOpen.insert(words[i]);

    temp = buff.readLine();
      }

  }//end try
  catch (IOException e){
      System.out.println("File I/O Error: " + inputFile);
  }

    }//end buildOpen

    //==========================================================
    // buildChain
    //
    // PURPOSE: Fill the given dictionary with the given text.
    //
    // PARAMETERS:
    //   allWordsChain - the dictionary to be filled
    //   inputFile - the file containing words to add to dictionary
    //
    // RETURNS:
    //   none
    //==========================================================
    static void buildChain(DictionaryChain allWordsChain, String inputFile){
  String temp;
  String[] words;

  try{
   BufferedReader buff = new BufferedReader(new FileReader(new File(inputFile)));

   temp = buff.readLine();
      while(temp != null){
       words = temp.split("[^a-zA-Z’]+");

    for (int i=0; i<words.length; i++)
         allWordsChain.insert(words[i]);

    temp = buff.readLine();
      }

  }//end try
  catch (IOException e){
      System.out.println("File I/O Error: " + inputFile);
  }

    }//end buildChain

    //==========================================================
    // searchOrdered
    //
    // PURPOSE: Search the given dictionary for the given words.
    //
    // PARAMETERS:
    //   allWordsOrdered - the dictionary to be searched
    //   searchFile - the file containing words to look for
    //
    // RETURNS:
    //   none (prints number of words found)
    //==========================================================
    static void searchOrdered(DictionaryOrdered allWordsOrdered, String searchFile){
  String temp;
  int numFound=0;
  int numMissing=0;

  try{

      Scanner scnner = new Scanner(new File(searchFile));
      while(scnner.hasNext()){

    temp = scnner.next();
    if (allWordsOrdered.search(temp))
        numFound++;
    else
        numMissing++;
      }
      System.out.println("Number of words found = " + numFound + ". Number of words not found = " + numMissing + ".");

  }//end try
  catch (IOException e){
      System.out.println("File I/O Error: " + searchFile);
  }

    }//end searchOrdered

    //==========================================================
    // searchOpen
    //
    // PURPOSE: Search the given dictionary for the given words.
    //
    // PARAMETERS:
    //   allWordsOpen - the dictionary to be searched
    //   searchFile - the file containing words to look for
    //
    // RETURNS:
    //   none (prints number of words found)
    //==========================================================
    static void searchOpen(DictionaryOpen allWordsOpen, String searchFile){
  String temp;
  int numFound=0;
  int numMissing=0;

  try{

      Scanner scnner = new Scanner(new File(searchFile));
      while(scnner.hasNext()){

    temp = scnner.next();
    if (allWordsOpen.search(temp))
        numFound++;
    else
        numMissing++;
      }
      System.out.println("Number of words found = " + numFound + ". Number of words not found = " + numMissing + ".");

  }//end try
  catch (IOException e){
      System.out.println("File I/O Error: " + searchFile);
  }

    }//end searchOpen

    //==========================================================
    // searchChain
    //
    // PURPOSE: Search the given dictionary for the given words.
    //
    // PARAMETERS:
    //   allWordsChain - the dictionary to be searched
    //   searchFile - the file containing words to look for
    //
    // RETURNS:
    //   none (prints number of words found)
    //==========================================================
    static void searchChain(DictionaryChain allWordsChain, String searchFile){
  String temp;
  int numFound=0;
  int numMissing=0;

  try{

      Scanner scnner = new Scanner(new File(searchFile));
      while(scnner.hasNext()){

    temp = scnner.next();
    if (allWordsChain.search(temp))
        numFound++;
    else
        numMissing++;
      }
      System.out.println("Number of words found = " + numFound + ". Number of words not found = " + numMissing + ".");

  }//end try
  catch (IOException e){
      System.out.println("File I/O Error: " + searchFile);
  }

    }//end searchChain

}//end class A3Q2template

//==============================================================
// DictionaryOrdered class
//
// PURPOSE: Store a list of words, in an ordered array.
//
// PUBLIC METHODS: - constructor: public Dictionary(int size)
//                 - public int getSize() - return the current number of words
//                 - public void insert(String newWord) - insert new word in list
//                 - public boolean search(String wordToFind) - search for
//                   given word and return true if found
// FOR TESTING: public void print() - print contents of dictionary
//==============================================================
class DictionaryOrdered{
  public String[] words;
  private int count;
  
  //constructor
  public DictionaryOrdered(int size){
    words = new String[size];
    count = 0;
  }
  
  //get the number of words in the dictionary
  public int getSize(){
    return count;
  }
  
  //insert a new word into the array. Doesn't accept duplicates
  public void insert(String newWord){
    newWord = newWord.toLowerCase();
    boolean found = search(newWord);
    if(isFull()){
      enlargeDict();
    }
    if(isEmpty()){
      words[0] = newWord;
      count++;
    }
    else{
      
      
      int i = count;
      while((i>0) && !found && (newWord.compareTo(words[i-1]) <= 0) ){
        words[i] = words[i-1];
        i--;
      }
      if(!found){
        words[i] = newWord;
        count++;
      }
    }
  }
  
  public boolean search(String word){
    word = word.toLowerCase();
    boolean found = false;
    int upperBound = count - 1;
    int lowerBound = 0;
    int mid = count/2;
    
    
    while((upperBound >= lowerBound) && !found){
      if(word.compareTo(words[mid]) < 0){
        upperBound = mid - 1;
      }
      else if (word.compareTo(words[mid]) > 0){
        lowerBound = mid + 1;
      }
      else{
        found = true;
      }
      mid = (upperBound+lowerBound)/2;
    }
    return found;
  }
  
  public String toString(){
    String s = "Dictionary: ";
    for(int i = 0; i < count; i++){
      s += "\n" + words[i] ;
    }
    return s;
  }
  
  /**************************************HELPER METHODS*******************************************/
  private boolean isFull(){
    return count == words.length;
  }
  
  private boolean isEmpty(){
    return count == 0;
  }
  
  private void enlargeDict(){
    String[] newDict = new String [words.length*2];
    for(int i = 0; i < count; i++){
      newDict[i] = words[i];
    }
    words = newDict;
  }
}
//
//
////==============================================================
//// DictionaryOpen class
////
//// PURPOSE: Store a list of words, in a hash table using open addressing.
////
//// PUBLIC METHODS: - constructor: public Dictionary(int size)
////                 - public int getSize() - return the current number of words
////                 - public void insert(String newWord) - insert new word in list
////                 - public boolean search(String wordToFind) - search for
////                   given word and return true if found
//// FOR TESTING: public void print() - print contents of dictionary
////
////==============================================================
class DictionaryOpen{
  public String[] dict;
  private int count;
  private static final double LOAD_FACTOR = 0.6;
  
  //costructor. takes a size and creates an array of size s
  //where s is the nearest prime number large than s
  public DictionaryOpen(int size){
    size = getNextPrime(size);
    dict = new String [size];
    count = 0;
  }
  
  public void insert(String newWord){
    if(!search(newWord)){
      newWord = newWord.toLowerCase();
      if(count >= LOAD_FACTOR*dict.length)
        enlargeDict();
      int key = getHashValue(newWord, dict.length);
      int stepSize = 0;
      if(dict[key] != null)
        stepSize = doubleHashing(newWord);
      while(dict[key] != null){
        key = (key + stepSize) % dict.length;
      }
      dict[key] = newWord;
      count++;
    }
  }
 
  public boolean search(String newWord){
    newWord = newWord.toLowerCase();
    int key = getHashValue(newWord,dict.length);
    int stepSize = 0;
    if(dict[key] != null && !dict[key].equals(newWord))
      stepSize = doubleHashing(newWord);
    int startPoint = key;
    boolean found = newWord.equals(dict[key]);
    key = (key + stepSize) % dict.length;
    while(!found && key != startPoint){
      if(newWord.equals(dict[key])){
        found = true;
        break;
      }
      key = (key + stepSize) % dict.length;
      //System.out.println("Checking next spot");
    }
    return found;
  }
  
  public int getSize(){
    return count;
  }
  
  public String toString(){
    String s = "Dictionary: ";
    for(int i = 0; i < dict.length; i++){
      s += "\n" + dict[i];
    }
    return s;
  }
  
  /**********************************HELPER METHODS****************************************/
  private boolean isPrime(int p){
    boolean prime = true;
    for(int i = 2; (i*i <= p)&& prime; i++){
      if(p%i == 0)
        prime = false;
    }
    return prime;
  }
  
  private int getNextPrime(int p){
    int nextPrime = p;
    while(!isPrime(nextPrime)){
      nextPrime++;
    }
    return nextPrime;
  }
  
  public static int getHashValue(String in, int hashArraySize){
      int hashValue = 0;
      int a = 27;
      
      
      for(char c: in.toCharArray()){
         hashValue = (hashValue*a) % hashArraySize;
         hashValue += (((int) c ) - 97) % hashArraySize;
      }
      return hashValue%hashArraySize;
  }
  
  private int doubleHashing(String in){
    int constant = 41;
    int sum = 0;
    for(char c: in.toCharArray()){
      if(c >= 'a' && c <= 'z')
         sum += (((int) c ) - 97);
      }
    int stepSize = constant - (sum%constant);
    
    return stepSize;
  }
  
  private void enlargeDict(){
    String[] newDict = new String[getNextPrime(dict.length+1)];
    int key;
    int stepSize;
    for(int i = 0; i < dict.length; i++){
      if(dict[i] != null){
        key = getHashValue(dict[i],newDict.length);
        stepSize = doubleHashing(dict[i]);
        while(newDict[key] != null){
          key = (key + stepSize) % newDict.length;
        }
        newDict[key] = dict[i]; 
      }
    }
    dict = newDict;
  }
  
  
}
//
//
////==============================================================
//// DictionaryChain class
////
//// PURPOSE: Store a list of words, in a hash table using separate
////          chaining. Words are converted to lowercase as inserted.
////
//// PUBLIC METHODS: - constructor: public Dictionary(int size)
////                 - public int getSize() - return the current number of words
////                 - public void insert(String newWord) - insert new word in list
////                 - public boolean search(String wordToFind) - search for
////                   given word and return true if found
//// FOR TESTING: public void print() - print contents of dictionary
////
////==============================================================
class DictionaryChain{
  public LinkedList[] dict;
  public int count;
  private static final double LOAD_FACTOR = 2.0;
  
  //constructor
  public DictionaryChain(int size){
    size = getNextPrime(size);
    dict = new LinkedList [size];
    count = 0;
  }
  
  //insert
  public void insert(String newItem){
    newItem = newItem.toLowerCase();
    if(!search(newItem)){
      ////System.out.println(newItem + " not found, inserting...");
      if(count >= dict.length*LOAD_FACTOR){
        ////System.out.println("Enlarging dict...");
        enlargeDict();
        ////System.out.println("Done...");
      }
      int key = getHashValue(newItem,dict.length);
      //System.out.println("key is " + key);
      if(dict[key] == null){
        ////System.out.println("Making new Linked List");
        dict[key] = new LinkedList();
        ////System.out.println("Done");
      }
      dict[key].add(newItem);
      
      count++;
    }
  }
  
  //search
  public boolean search(String lookup){
    lookup = lookup.toLowerCase();
    boolean found = false;
    //////System.out.println("Checking...");
    int key = getHashValue(lookup,dict.length);
    //////System.out.println("hashvalue is: " + key);
    if(dict[key] != null)
      found = dict[key].search(lookup);
    //////System.out.println("found? " + found);
    return found;
  }
  
  //toString
  public String toString(){
    String s = "Dictionary: ";
    for(LinkedList ll: dict){
      if(ll != null)
        s+= ll + "\n";
    }
    return s;
  }
  
  //getSize
  public int getSize(){
    return count;
  }
  
  /******************************HELPER METHODS***********************************/
  private boolean isPrime(int p){
    boolean prime = true;
    for(int i = 2; (i*i <= p)&& prime; i++){
      if(p%i == 0)
        prime = false;
    }
    return prime;
  }
  
  private int getNextPrime(int p){
    int nextPrime = p;
    while(!isPrime(nextPrime)){
      nextPrime++;
    }
    return nextPrime;
  }
  
  public static int getHashValue(String in, int hashArraySize){
      int hashValue = 0;
      int a = 27;
      
      for(char c: in.toCharArray()){
         hashValue = (hashValue*a) % hashArraySize;
         hashValue += (((int) c ) - 97) % hashArraySize;
      }
      return hashValue%hashArraySize;
  }
  
  private void enlargeDict(){
    //System.out.println("Enlarging...");
    LinkedList[] newDict = new LinkedList[getNextPrime(dict.length+1)];
    int key;
    int stepSize;
    for(int i = 0; i < dict.length; i++){
      if(dict[i] != null){
        Node curr = dict[i].top;
        while(curr != null){
          key = getHashValue(curr.data,newDict.length);
          if(newDict[key] == null)
            newDict[key] = new LinkedList();
          newDict[key].add(curr.data);
          curr = curr.next;
        }
      }
    }
    dict = newDict;
    //System.out.println("Done");
  }
}

class LinkedList{
  public Node top;
  
  public LinkedList(){
    top = null;
  }
  
  public void add(String i){
    if(isEmpty())
      top = new Node(i,null);
    else{
      Node newNode = new Node(i,top);
      top = newNode;
    }
  }
  
  public boolean search(String s){
    boolean found = false;
    Node curr = top;
    while(curr != null && !found){
      if(curr.data.equals(s))
        found = true;
      curr = curr.next;
    }
    return found;
  }
  
  
  public boolean isEmpty(){
    return top == null;
  }
  
  public boolean isFull(){return false;}
  
  public String toString(){
    String s = "";
    Node curr = top;
    while(curr != null){
      s += "\n" + curr.data ;
      curr = curr.next;
    }
    return s ;
  }
}

class Node{
  public String data;
  public Node next;
  
  //constructor
  public Node(String data, Node next){
    this.data = data;
    this.next = next;
  }
}


