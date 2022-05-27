import java.util.Scanner;
public class Combination{

   public static void main(String[] args){
      
      System.out.print("Enter N: ");
      int N = new Scanner(System.in).nextInt();
      System.out.print("Enter R: ");
      int R = new Scanner(System.in).nextInt();
      
      long N_Factorial = factorial(N);
      long R_Factorial = factorial(R);
      long N_minus_R_Factorial = factorial(N-R);
      
      double combination = N_Factorial / (R_Factorial * N_minus_R_Factorial);
      
      System.out.println("Combination");
      System.out.println("C("+N+","+R+") = "+combination);
   }
   
    private static long factorial(long x){
      if(x > 20 || x < 0)
         return -1;
      if(x == 0)
         return 1;
      return x * factorial(x-1);
   }
}