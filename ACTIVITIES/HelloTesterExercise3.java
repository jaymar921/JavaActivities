public class HelloTesterExercise3{

   // main method
   public static void main(String[] args){
      System.out.println("Enter Greeting: ");
      new Hello(new java.util.Scanner(System.in).nextLine());
   }
   
   static class Hello{
      // constructor
      public Hello(String greeting){
         System.out.println("\n"+greeting);
      }
   }
}