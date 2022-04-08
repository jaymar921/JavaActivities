public class Matrix{
   public static void main(String... args){
      
      
      int col = 5;
      int row = 5;
      
      int increment = 0;
      for(int i = 0; i < col; i++){
         for(int j = 0; j < row; j++){
            increment++;
            System.out.print("  "+(increment));
         }
         System.out.println();
      }
   }
}