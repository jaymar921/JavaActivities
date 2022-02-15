/**
	Abejar, Jayharron Mar Canillo
	BSIT - -2
	OOPROG - EXERCISE 4
	A TESTER CLASS FOR THE STUDENT CLASS
**/
import java.util.Scanner;
public class StudentTester{
   
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Student s1, s2, s3;
      Student.birthdate b1, b2, b3;
      s1 = new Student();
      s2 = new Student();
      s3 = new Student();
      b1 = s1.new birthdate();
      b2 = s2.new birthdate();
      b3 = s3.new birthdate();
      
      //STUDENT 1
      System.out.println("Fill up Student 1");
      System.out.print("Lastname: ");
      s1.setLastname(input.next());
      System.out.print("firstname: ");
      s1.setFirstname(input.next());
      System.out.print("Gender [M|F]: ");
      s1.setGender(input.next().charAt(0));
      System.out.print("Course: ");
      s1.setCourse(input.next());
      System.out.print("Year: ");
      s1.setLevel(input.nextInt());
      System.out.println("Birthdate for student 1");
      b1.enterInfo();
      //STUDENT 2
      System.out.println("\nFill up Student 2");
      System.out.print("Lastname: ");
      s2.setLastname(input.next());
      System.out.print("firstname: ");
      s2.setFirstname(input.next());
      System.out.print("Gender [M|F]: ");
      s2.setGender(input.next().charAt(0));
      System.out.print("Course: ");
      s2.setCourse(input.next());
      System.out.print("Year: ");
      s2.setLevel(input.nextInt());
      System.out.println("Birthdate for student 2");
      b2.enterInfo();
      //STUDENT 3
      System.out.println("\nFill up Student 3 ");
      System.out.print("Lastname: ");
      s3.setLastname(input.next());
      System.out.print("firstname: ");
      s3.setFirstname(input.next());
      System.out.print("Gender [M|F]: ");
      s3.setGender(input.next().charAt(0));
      System.out.print("Course: ");
      s3.setCourse(input.next());
      System.out.print("Year: ");
      s3.setLevel(input.nextInt());
      System.out.println("Birthdate for student 3");
      b3.enterInfo();
      
      //DISPLAY THE 3 STUDENTS
      System.out.println("\n"+s1.toString() + " "+b1.toString());
      System.out.println("\n"+s2.toString() + " "+b2.toString());
      System.out.println("\n"+s3.toString() + " "+b3.toString());
   
   }//end of main 
   
}//End of student tester class