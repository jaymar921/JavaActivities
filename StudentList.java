/**
   Student List-an array of Student Objects
*/
public class StudentList{
   //define the data container for the Student list
    //utility variable(s)
   private Student[] list;
   private int count;
   //constructors
   public StudentList(int size){
      this.list = new Student[size];
   }
   //default constructor 
   public StudentList(){
      this(10);
   }
   //create sentinel methods(methods that monitor the current status(empty|full) of the container)
   public boolean isEmpty(){
      boolean Ok = list.length==0; //I get the lenght of the list, if 0 then its empty
      return Ok;
   }
   public boolean isFull(){
      boolean isFull = list.length == count;
      return isFull;
   }
   //create a method that will allow new Student to be accepted and placed on the array
   public boolean addStudent(Student s){
   if(!isFull()){  //if the list is not yet full, you can still add something in the list
      list[count++] = s; //add
      return true; //return true if added
      }
      return false;//return false if not added, it will send and error message to the user(Error adding student)
   }
   //create a method to display all student list
   //by overriding the toString() method
   public String toString(){
  
      //using a mutable String
       StringBuffer bf = new StringBuffer();
       for(int i = 0; i < count; i++){
         bf.append(list[i]).append("\n"); 
       }
       
       return bf.toString();
   }
}//end of class