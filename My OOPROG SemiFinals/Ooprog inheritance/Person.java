/**
   By: Jayharron Mar C. Abejar
   This class contains the following attributes
   - last name
   - first name
   - gender
   
   the following attributes are set to private, in order to access those following attributes
   the Person class must provide setters and getters
*/
public class Person{
   
   //attributes
   private String lastname;
   private String firstname;
   private String gender;
   
   //constructors
   public Person(String lastname, String firstname, String gender){
      this.lastname = lastname;
      this.firstname =firstname;
      this.gender = gender;
   }
   //default constructor
   public Person(){}
   
   //setters and getters
   public void setLastname(String lastname){
      this.lastname = lastname;
   }
   public void setFirstname(String firstname){
      this.firstname = firstname;
   }
   public void setGender(String gender){
      this.gender = gender;
   }
   
   public String getLastname(){
      return this.lastname;
   }
   
   public String getFirstname(){
      return this.firstname;
   }
   
   public String getGender(){
      char gen = '\u0000';
      gen = Character.toLowerCase(gender.charAt(0));
      if(gen == 'm')
         this.gender = "Male ";
      else if(gen == 'f')
         this.gender = "Female";
      else
         this.gender =  "Unspecified";
      return this.gender;
   }
   
   //override the toString method
   public String toString(){
      return getLastname() + ", " + getFirstname() + " - " +getGender();
   }

} //end of person class
