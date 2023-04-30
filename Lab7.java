import java.util.Scanner;

public class Lab7{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
   
      String word = input.next();
      System.out.println(getHashValue(word,3));
   }//main
   
   public static int getHashValue(String in, int hashArraySize){
      int hashValue = 0;
      int a = 27;
      
      
      for(char c: in.toCharArray()){
         hashValue = (hashValue*a) % hashArraySize;
         hashValue += (((int) c ) - 97) % hashArraySize;
      }
      return hashValue%hashArraySize;
   }//getHashValue
}//lab7