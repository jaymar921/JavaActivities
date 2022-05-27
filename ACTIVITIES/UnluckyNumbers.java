public class UnluckyNumbers{
   private static long p_0 = 0;
   private static long p_1 = 0;
   // main method
   public static void main(String[] args){
      while(true){
         System.out.print("Enter a non negative integer: ");
         int n = new java.util.Scanner(System.in).nextInt();
         if(n < 0)
            break;
         
         if(checkLuckyNumber(n))
            System.out.println("Safe");
         else
            System.out.println("Unlucky");
         p_0 = 0;
         p_1 = 0;
      }
   }
   
   public static boolean checkLuckyNumber(long n){
      long r = n%10;
      
      n = n/10;
      p_0 = r;
      
      if(p_0 == 1 && p_1 == 3){
         return false;
      }
      p_1 = r;
      if(n == 0){
         return true;
      }
      else
         return checkLuckyNumber(n);
   }
}