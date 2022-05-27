public class HelloObject1{

   private String message;
   // contructor
   public HelloObject1(String message){
      this.message = message;
   }
   
   public void Print(){
      for(char x: message.toCharArray())
         System.out.println(message);
   }
   
   // main method
   public static void main(String[] args){
      new HelloObject1("Hello").Print();
   }
}