public class OdiousNumbers{
   
   // main method
   public static void main(String[] args){
      while(true){
         System.out.print("Enter a non negative integer: ");
         int n = new java.util.Scanner(System.in).nextInt();
         if(n < 0)
            break;
         
         if(checkOdiousNumber(n,0))
            System.out.println("Odious Number.");
         else
            System.out.println("Evil Number.");
         
      }
   }
   
   private static boolean checkOdiousNumber(long n,int x){
      long r = n%2;
      if(r == 1)
         x++;
      n = n/2;
      
      if(n == 0){
         
         if(x%2==0){
            return false;
         }else{
            return true;
         }
      }else
         return checkOdiousNumber(n,x);
   }
}