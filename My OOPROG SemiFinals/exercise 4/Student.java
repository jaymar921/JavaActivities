/**
   ABEJAR, JAYHARRON MAR CANILLO
   BSIT - 2
   
   Student class
   Object Oriented PROGRAMMING 
   EXERCISE # 4
**/

public class Student{
   
   //Student class attributes
   private String lastname;
   private String firstname;
   private int yearLevel;
   private char gender;
   private String course;
   
   //birthdate inner class
   class birthdate{
   //birthdate class attributes
      private int day;
      private int month;
      private int year;
      
      //birthdate class constructors
      public birthdate(int day, int month, int year){
         this.day = day;
         this.month = month;
         this.year = year;
      }
      public birthdate(){
      
      }
      
      //setters
      public void setDay(int day){
         this.day = day;
      }
      public void setMonth(int mon){
         this.month = mon;
      }
      public void setYear(int year){
         this.year = year;
      }
      
      //getters
      public int getDay(){
         return this.day;
      }
      public int getMonth(){
         return this.month;
      }
      public int getYear(){
         return this.year;
      }
      //to string
      public String toString(){
         return "Birthdate: "+this.month+"/"+this.day+"/"+this.year;
      }
      
      public boolean enterInfo(){
      boolean again = true;
      do{
         try{// I put try catch to get the exception if the user entered invalid input
            System.out.print("Enter birth day: ");
            setDay(new java.util.Scanner(System.in).nextInt());
            System.out.print("Enter birth month: ");
            setMonth(new java.util.Scanner(System.in).nextInt());
            System.out.print("Enter birth year: ");
            setYear(new java.util.Scanner(System.in).nextInt());
            again = false;
         }catch(Exception e){
            System.out.println("You can only enter numbers!"); //error message if user entered the wrong input
         }
         }while(again);// user enter the wrong input, it repeats again!
         return true;
      }
      
   }
   
   //Student class constructors
   public Student(String lastname, String firstname, int year, char gender, String course){
      this.lastname = lastname;
      this.firstname = firstname;
      this.yearLevel = year;
      this.gender = gender;
      this.course = course;
   }
   public Student(){
   
   }
   
   //setters
   public void setLastname(String lastname){
      this.lastname = lastname;
   }
   public void setFirstname(String firstname){
      this.firstname = firstname;
   }
   public void setLevel(int level){
      this.yearLevel = level;
   }
   public void setGender(char gender){
   char gen = Character.toLowerCase(gender);
   if(gen == 'm' || gen == 'f')
      this.gender = gen;
   }
   public void setCourse(String course){
      this.course = course;
   }
   
   //gettters
   public String getLastname(){
      return this.lastname;
   }
   public String getFirstname(){
      return this.firstname;
   }
   public int getLevel(){
      return this.yearLevel;
   }
   public String getGender(){
   if(gender == 'm')
      return "Male";
   else if(gender == 'f')
      return "Female";
   else
      return "Not Specified";
   }
   public String getCourse(){
      return this.course;
   }
   //to string , it grabs the attribute information inside the Student class and returns the data collected
   public String toString(){
      return getLastname() + ", " +getFirstname()+" | "+getGender() + " | "+ getCourse() + " " + getLevel();
   }
   
}//End of Student Class