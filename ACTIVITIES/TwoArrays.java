public class TwoArrays{
   
   public static void main(String[] args){
       int[] val = {13, -4, 82, 17}; 
       int[] twice;
       
       System.out.println( "Original Array: " 
           + val[0] + " " + val[1] + " " + val[2] + " " + val[3] );
    
       // Construct an array object for twice.
       twice = new int[val.length];
       
       // Put values in twice that are twice the
       // corresponding values in val.
       for(int i = 0; i < val.length; i++)
         twice[i] = val[i]*2;
   
    
       System.out.println( "New Array: " 
           + twice[0] + " " + twice[1] + " " + twice[2] + " " + twice[3] );
   }
}