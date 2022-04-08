public class PrivateTest{

   public static void main(String... args){
   
      PrivateClass p = new PrivateClass(){
         public PrivateClass changeName(String name){
            super.setName(name);
            return this;
         }
      };
      
      p.changeName("JayMar");
      p.print();
   }
}

class PrivateClass{
   private String name = "";
   
   private void setName(String name){
      this.name = name;
   }
   
   public void print(){
      System.out.println("Name: "+name);
   }
}