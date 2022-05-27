public class HelloObject2{

   private String morningGreeting;
   private String eveningGreeting;
   
   // class constructor
   public HelloObject2(String g1, String g2){
      morningGreeting = g1;
      eveningGreeting = g2;
   }
   
   public void Print(){
      System.out.println(morningGreeting);
      System.out.println(eveningGreeting);
   }
   
   // main method
   public static void main(String[] args){
      new HelloObject2("Good morning world!","Good evening world!").Print();
   }
}