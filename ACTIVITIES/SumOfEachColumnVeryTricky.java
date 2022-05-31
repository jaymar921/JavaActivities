import java.io.* ;

public class SumOfEachColumnVeryTricky
{

  public static void main ( String[] args ) 
  {
    int[][] data = { {3, 2, 5},
                     {1, 4, 4, 8, 13},
                     {9, 1, 0, 2},
                     {0, 2, 6, 3, -1, -8} };
    
    int[] col_data = new int[4];
    int sum = 0;
    int increment = 0;  
    
    for(int i = 0; i < 6; i++){
      col_data = new int[4];
      sum = 0;
      increment = 0;
      for ( int row=0; row < data.length; row++)
       {
         
         for ( int col=0; col < data[row].length; col++) 
         {
            if(i >= data[row].length){
               break;
            }
            col_data[increment++] = data[row][i];
            //System.out.println(data[row][i]);
            break;
            //if(data[i].length > i){
            //   System.out.print(data[row][i]+" -> row: "+row +"  i: "+i+" lenght: "+data[row].length);
            //   break;
            //}
         }
         
         
         //System.out.println("Sum of column["+(row+1)+"] is -> "+sum);
       }
       //System.out.println();
       
       for(int x : col_data)
         sum += x;
       
       System.out.println("Sum in col["+(i+1)+"] -> "+ sum);

    }      
  }
}     