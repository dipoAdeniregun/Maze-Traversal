//public class DictionaryOrdered{
//  public String[] words;
//  private int count;
//  
//  //constructor
//  public DictionaryOrdered(int size){
//    words = new String[size];
//    count = 0;
//  }
//  
//  //get the number of words in the dictionary
//  public int getSize(){
//    return count;
//  }
//  
//  //insert a new word into the array. Doesn't accept duplicates
//  public void insert(String newWord){
//    newWord = newWord.toLowerCase();
//    boolean found = search(newWord);
//    if(isFull()){
//      enlargeDict();
//    }
//    if(isEmpty()){
//      words[0] = newWord;
//      count++;
//    }
//    else{
//      
//      
//      int i = count;
//      while((i>0) && !found && (newWord.compareTo(words[i-1]) <= 0) ){
//        words[i] = words[i-1];
//        i--;
//      }
//      if(!found){
//        words[i] = newWord;
//        count++;
//      }
//    }
//  }
//  
//  public boolean search(String word){
//    word = word.toLowerCase();
//    boolean found = false;
//    int upperBound = count - 1;
//    int lowerBound = 0;
//    int mid = count/2;
//    
//    
//    while((upperBound >= lowerBound) && !found){
//      if(word.compareTo(words[mid]) < 0){
//        upperBound = mid - 1;
//      }
//      else if (word.compareTo(words[mid]) > 0){
//        lowerBound = mid + 1;
//      }
//      else{
//        found = true;
//      }
//      mid = (upperBound+lowerBound)/2;
//    }
//    return found;
//  }
//  
//  public String toString(){
//    String s = "Dictionary: ";
//    for(int i = 0; i < count; i++){
//      s += "\n" + words[i] ;
//    }
//    return s;
//  }
//  
//  /**************************************HELPER METHODS*******************************************/
//  private boolean isFull(){
//    return count == words.length;
//  }
//  
//  private boolean isEmpty(){
//    return count == 0;
//  }
//  
//  private void enlargeDict(){
//    String[] newDict = new String [words.length*2];
//    for(int i = 0; i < count; i++){
//      newDict[i] = words[i];
//    }
//    words = newDict;
//  }
//}