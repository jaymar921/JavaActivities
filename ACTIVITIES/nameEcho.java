import java.util.Scanner;
public class nameEcho{

   public static void main(String... args){
      
      System.out.print("Enter your name:");
      String name = new Scanner(System.in).nextLine().trim();
      
      // split the name with spaces
      String[] name_fragment = name.split(" ");
      
      // firstname is always at index 0
      String firstname = name_fragment[0];
      
      // get the lastname
      String lastname = "";
      // check if the size of the array is > 1
      if(name_fragment.length > 1){
         for(int i = 1; i < name_fragment.length; i++){
            if(i == name_fragment.length-1)
               lastname = name_fragment[name_fragment.length-1];
            else
               firstname+=" "+name_fragment[i].trim().substring(0);
         }
         
      }
      
      // print the firstname and lastname
      
      System.out.println(firstname + " " + lastname.toUpperCase());
      
      /*
         Kani sya comment ni
         Pia is cool :)
      */
      
   }
}