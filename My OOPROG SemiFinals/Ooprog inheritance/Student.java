/**
   Student class
   a (child)Subclass of the Parent Class which contains the 
   following instance variables:
   
   String Course
   int YearLevel (1 - 4)
   String emailAddress
   String mobileNumber
**/
public class Student extends Person{

   //attributes
   private String course;
   private int year;
   private String emailAddress;
   private String mobileNumber;
   
   //constructors
   public Student(String lname, String fname, String gender, String course, int year, String email, String mobile){
      super(lname, fname, gender);
      this.course = course;
      this.emailAddress = email;
      this.year = year;
      this.mobileNumber = mobile;
   }
   public Student(){}
   
   //setters and getters
   public void setCourse(String course){
      this.course = course;
   }
   public void setYear(int year){
      if(year>0 && year <=4)
      this.year = year;
   }
   public void setEmail(String email){
      this.emailAddress = email;
   }
   public void setNumber(String number){
      this.mobileNumber = number;
   }
   
   public String getCourse(){
      return this.course;
   }
   public int getYear(){
      return this.year;
   }
   public String getEmail(){
      return this.emailAddress;
   }
   public String getNumber(){
      return this.mobileNumber;
   }
   
   //Override the toString method
   public String toString(){
      return super.toString() + " | " + this.course + " " + this.year + " " + this.emailAddress + " " + this.mobileNumber;
   }
   
   //main 
   public static void main(String... args){
      Student s1 = new Student();               // <- creates the student object
      s1.setLastname("Abejar");                 // <- sets the lastname 
      s1.setFirstname("Jayharron");             // <- sets the firstname
      s1.setGender("M");                        // <- sets the gender
      s1.setCourse("BSIT");                     // <- sets the course
      s1.setYear(1);                            // <- sets the year
      s1.setEmail("jayharronabejar@gmail.com"); // <- sets the email Address
      s1.setNumber("0916***9411");              // <- sets the mobile number
      
      System.out.print(s1);                     // <- prints the student object
      
   }//end of main


}//end of student class