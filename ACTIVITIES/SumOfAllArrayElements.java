import java.io.* ;

public class SumOfAllArrayElements
{

  public static void main ( String[] args )  
  {
    int[][] data = { {3, 2, 5},
                     {1, 4, 4, 8, 13},
                     {9, 1, 0, 2},
                     {0, 2, 6, 3, -1, -8} };
    
    // declare the sum
    int sum = 0;
    
    // compute the sum
    for ( int row=0; row < data.length; row++)
    {
      for ( int col=0; col < data[row].length; col++) 
      {
        sum+=data[row][col];
      }
    }
      
    // write out the sum
    System.out.println("sum -> " + sum);

  }
}      