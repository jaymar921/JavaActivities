/**
   STUDENT CLASS
   BY: JAYHARRON MAR ABEJAR
   
   THIS CLASS HAS A RELATION WITH BIRTHDATE CLASS
   
   STUDENT CLASS CONTAINS THE FF.
   attributes
   -lastname   string
   -firstname  string
   -birthdate (birthdate class)
   -gender     char
   -yearLevel  int
   -course     string
   -idno       int
   
   sets
   -lastname
   -firstname
   -birthdate
   -gender
   -yearlvl
   -course
   -idno
   
   gets
   -lastname
   -firstname
   -birthdate
   -gender (returns a string eg. "Male" | "Female")
   -yearLevel
   -course
   -idno
   
   toString
      Student Name: <lastname>, <firstname> | <idno> | <gender> | birthdate: <birthdate> | course: <course> - <yearLevel>
**/
public class Student{
   //defining the attributes
   private String lastname;
   private String firstname;
   private Birthdate birthdate;
   private char gender;
   private int yearLevel;
   private String course;
   private int idno;
   //creating the constructors
   public Student(String lastname, String firstname, Birthdate birthdate, char gender, int yrl, String course, int idno){
      this.lastname = lastname;
      this.firstname = firstname;
      this.birthdate = birthdate;
      this.gender = gender;
      if(yrl >= 1 && yrl <= 4)
         this.yearLevel = yrl;
      else
         this.yearLevel = 0;
      this.course = course;
      this.idno = idno;
   }
   public Student(){}
   
   //setters
   public void setLastname(String lastname)           {  this.lastname = lastname;}
   public void setFirstname(String firstname)         {  this.firstname = firstname;}
   public void setBirthdate(Birthdate birthdate)      {  this.birthdate = birthdate;}
   public void setGender(char gender){  
      char gen = Character.toUpperCase(gender);
      if(gen == 'M' || gen == 'F')
         this.gender = gen;
   }
   public void setYearLevel(int yearLevel){ 
      if(yearLevel >= 1 && yearLevel <= 4)
		   this.yearLevel  = yearLevel; 
   }
   public void setCourse(String course)               {  this.course = course;}
   public void setIdNumber(int idno)                  {  this.idno = idno;}
   //gettters
   public String getLastname()                        {  return this.lastname;}
   public String getFirstname()                       {  return this.firstname;}
   public Birthdate getBirthdate()                    {  return this.birthdate;}
   public String getGender(){
      char gen = Character.toUpperCase(this.gender);
      if(gen == 'M')
         return "Male";
      else if (gen == 'F')
         return "Female";
      else
         return "Not Specified";
   }
   public int getYearLevel()                          {  return this.yearLevel;}
   public String getCourse()                          {  return this.course;}
   public int getIdNumber()                           {  return this.idno;}
   
   //override the toString method
   public String toString(){
      return "Name:"+ getLastname() + "," + getFirstname() + "| " + getIdNumber() + " | " + getGender() + " | " + getBirthdate() +  " | " + getCourse() + " - " + getYearLevel()  ;
   }
}//end of Student class