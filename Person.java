/**
   Person class
   -----------------
*/

public class Person{
   //define the encapsulated properties
   private String lastname, firstname, mi;
   //define constructor-> a special method(function) used only during instantiation(process of converting
   //class into an Object)
   //the constructor will bear the name of the class
   public Person(String lastname,String firstname,String mi){
      this.lastname = lastname;
      this.firstname = firstname;
      this.mi = mi;
   }
   //default constructor
   //most experts suggest, that you must have at least a default constructor
   public Person(){}
   //setters - a collection of methods used to UPDATE the encapsulated properties of the Object
   public void setLastname(String lastname){
      this.lastname = lastname; //set the first name
   }
   public void setFirstname(String firstname){
      this.firstname = firstname; //set the last name
   }
   public void setMiddleInitial(String mi){
      this.mi = mi;
   }
   //getters- a collection of methods used to ACCESS the encapsulated properties of the Object
   public String getFirstName(){
      return this.firstname; //get the first name
   }
   public String getLastName(){
      return this.lastname; //get the last name
   }
   public String getMiddleInitial(){
      return this.mi; //get the middle initial
   }
   //override the toString() - override means replace the functional code of the inherited func
   public String toString(){
      return lastname + " " + firstname+" "+mi;
   }
}//end of class