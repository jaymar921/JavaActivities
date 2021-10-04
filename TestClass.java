/**
   Abejar, Jayharron Mar C. BSIT -2
   TestClass
*/
public class TestClass{
   static private void mymenu(){
      String[] menuitem={
         "      Main Menu        ",
         "---------------------- ",
         "1. Create Student List ",
         "2. Add New Student     ",
         "3. Display Student List",
         "0. Quit/Exit           ",
         "-----------------------"
      };
      for(String s:menuitem) 
         System.out.println(s);
   }
   static public void main(String... args){
        StudentList list=null;
        char ch='\u0000'; //null character->does not represent any character
        while(ch!='0'){
            mymenu();
            ch=new java.util.Scanner(System.in).nextLine().charAt(0);
            switch(ch){
               case '1': //create the student list
                  System.out.println("Create the Student List");
                  System.out.println("-----------------------");
                  System.out.println("Enter list size(n):");
                     try{
                        int size=new java.util.Scanner(System.in).nextInt();
                        list=new StudentList(size);
                     }catch(Exception e){
                        System.out.println("Size value error");
                     }
                  break;
               case '2': // add new student
                  if(list!=null){ //cannot add new student if list is null
                     System.out.println("Add New Student List");
                     System.out.println("-----------------------");
                     System.out.print("IDNO      :"); 
                        String idno=new java.util.Scanner(System.in).nextLine();
                     System.out.print("LASTNAME  :"); 
                        String lastname=new java.util.Scanner(System.in).nextLine();
                     System.out.print("FIRSTNAME :"); 
                        String firstname=new java.util.Scanner(System.in).nextLine();
                     System.out.print("MI        :"); 
                        String mi=new java.util.Scanner(System.in).nextLine();
                     System.out.print("COURSE    :"); 
                        String course=new java.util.Scanner(System.in).nextLine();
                     System.out.print("LEVEL     :"); 
                        String level=new java.util.Scanner(System.in).nextLine();
                     boolean ok=list.addStudent(new Student(idno,lastname,firstname,mi,course,level));   
                     String message=(ok)?"New Student Added":"Error Adding Student"; //ternary operator
                     System.out.println(message);
                  }
                  break;
               case '3': //display the student list
                  if(list!=null){
                     System.out.println(list);
                  }
                  break;
               case '0': System.out.println("Program Terminated");
            }
        }
   }
}//end of class