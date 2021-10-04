/**
   Student class
   ------------
   this class inherits from the Person class
*/
public class Student extends Person{
   //only public,protected and friendly properties of the Person Object can be inherited
   //private aRE NOT INHERITED
   
   //define student's own private properties
   private String idno, course, level;
   //define the constructors
   public Student(String idno,String lastname,String firstname,String mi,String course,String level){
      super(lastname,firstname,mi);
      this.idno = idno;
      this.course = course;
      this.level = level;
   }
   //default constructor
   public Student(){}
   //setters
   public void setIdNumber(String idno){
      this.idno = idno; //set the id number
   }
   public void setCourse(String course){
      this.course = course; //set the course
   }
   public void setLevel(String level){
      this.level = level; //set the level
   }
   
   //getters
   public String getIdNumber(){
      return idno; //get id no
   }
   public String getCourse(){
      return course; //get course
   }
   public String getLevel(){
      return level; //get level
   }
   //override the toString() method
   public String toString(){
      return idno + " "+super.toString()+ " " + course + " " + level;  
   }
}//end of class