import java.util.Scanner;
public class WordTriangle{
   public static void main(String... args){
      
      System.out.print("Enter a word --> ");
      char[] word = new Scanner(System.in).nextLine().toCharArray();
      
      int size = word.length;
      
      int left = 0;
      int right = size-1;
      
      for(int i = 0; i < size; i++){
         System.out.println(word);
         word[left++] = ' ';
         word[right--] = ' ';
      }
   }
}