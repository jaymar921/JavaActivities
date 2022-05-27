import java.util.Scanner;
public class TitleApplier{
   
   public static void main(String[] args){
   
      String[] girls = {"Amy","Buffy","Cathy"};
      String[] boys = {"Elroy","Fred","Graham"};
      
      System.out.println("Enter a name: ");
      
      String name = new Scanner(System.in).nextLine();
     
      for(String girl: girls){
         if(name.toLowerCase().startsWith(girl.toLowerCase())){
            System.out.println("Ms. "+name);
            break;
         }
      }
      for(String boy: boys){
         if(name.toLowerCase().startsWith(boy.toLowerCase())){
            System.out.println("Mr. "+name);
            break;
         }
      }
   }
}