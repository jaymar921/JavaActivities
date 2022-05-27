import java.util.Scanner;
public class FactorialWithErrorFlag{
   public static void main(String[] args){
      
      System.out.println("Enter a number");
      int n = new Scanner(System.in).nextInt();
      
      long result = factorial(n);
      
      if(result>0){
         System.out.println("Factorial of "+n+"! is "+result);
      }else{
         System.out.println("You cannot enter a value greater than 20");
      }
   }
   
   private static long factorial(long x){
      if(x > 20 || x < 0)
         return -1;
      if(x == 0)
         return 1;
      return x * factorial(x-1);
   }
}