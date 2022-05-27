import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class PerfectNumbers{
   
   public static void main(String[] args){
      
      // prompt the user
      System.out.println("Enter a number: ");
      int n = new Scanner(System.in).nextInt();
      
      for(int x = 1; x < n; x++){
         if(perfectNumber(x))
            System.out.println(x+" is a PERFECT number");
         else
            System.out.println(x+" is NOT a perfect number");   
      }
     
   }
   
   private static boolean perfectNumber(int n){
      List<Integer> proper_divisors = new ArrayList<Integer>();
      int increment = 0;
      
      for(int N = 1; N < n; N++){
         if(n % N ==0)
            proper_divisors.add(N);
      }
      int sum = 0;
      for(int x : proper_divisors){
         sum += x;
      }
      
      
      if(sum == n)
         return true;
      return false;
   }
}