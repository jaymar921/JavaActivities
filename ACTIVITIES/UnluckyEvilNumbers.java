public class UnluckyEvilNumbers{
   private static long p_0 = 0;
   private static long p_1 = 0;
   
   public static void main(String[] args){
      
      for(int i = 1; i <= 20; i++){
         if(checkOdiousNumber(i,0)){
            System.out.print(i+" is Odius Number");
         }else{
            System.out.print(i+" is Evil Number");
         }
         if(checkLuckyNumber(i)){
            System.out.print(" and is a Lucky Number\n");
         }else{
            System.out.print(" and is an unlucky Number\n");
         }
         p_0 = 0;
         p_1 = 0;
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