public class HelloObject4{
   
   String greeting;
   // constructor
   public HelloObject4(String greeting){
      this.greeting = greeting;
   }
   // The additional constructor 
   public HelloObject4(HelloObject4 obj){
      this.greeting = obj.greeting;
   }
   public static void main(String[] args){
      HelloObject4 obj1 = new HelloObject4("Hello Pia");
      
      HelloObject4 obj2 = new HelloObject4(obj1);
      
      System.out.println(obj2.greeting);
   }
}