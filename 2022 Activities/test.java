public class test{
   public static void main(String... args){
      
      Company company = new Company("Arlo Corp", 20, "Talisay City"){
         @Override
         public String toString(){
            return "name: " + name + " no of emp: " + noOfEmp + " Address: " + address;
         }
         
         public void myMethod(){
            System.out.println("Hello World");
         }
      };
      
      System.out.println(company);
      company.myMethod();
   }
}

class Company{
   public String name;
   public int noOfEmp;
   public String address;
   
   public Company(String name, int noOfEmp, String address){
      this.name = name;
      this.noOfEmp = noOfEmp;
      this.address = address;
   }
}