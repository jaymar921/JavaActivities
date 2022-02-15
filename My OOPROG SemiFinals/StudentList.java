/**
   STUDENTLIST
   BY: ABEJAR, JAYHARRON MAR C
   
   STUDENT LIST IMPLEMENTS LIST<INTERFACE>
   IT HAS THE FF. ALLOWABLE OPERATIONS
   -add(Object object)
   -isFound(int idNumber)
   -remove(id number)
**/
public class StudentList implements List{
   //define the data container
   private Student[] student;
   //utility variables
   private int count,idno;
   
   //constructors
   public StudentList(int size)           {  student = new Student[size];}
   public StudentList()                   {  this(10);}
   
   //sentinel methods
   public boolean isFull()                {  return count==student.length;}
   public boolean isEmpty()               {  return count==0;}
   
   //double the array
   public void doubleTheArray(){
      Student[] temp = student;
      student = new Student[student.length*2];
      for(int i = 0; i < count; i++){
         student[i] = temp[i];
      }
   }
   
   //allowable operation from the list interface
   public void add(Object object){
      boolean ok = !isFull();
      if(ok){
         if(object instanceof Student){
            Student new_student = (Student)object;
            student[count++] = new_student;
         }
      }else    doubleTheArray();
   }
   
   public boolean isFound(int idNumber){
      if(!isEmpty()){
         for(int i = 0;i<count;i++){
            if(student[i].getIdNumber() == idNumber)
               return true;
         }
      }
      return false;
   }
   public void remove(int idNumber){
      if(!isEmpty()){
         for(int i = 0; i < count; i ++)
            if(student[i].getIdNumber() == idNumber){
               for(int j = i; j < count;j++)
                  student[j] = student[j+1];
               student[count] = null;
               count--;
               break;
            }       
      }
   }
   
   //toString
   public String toString(){
      StringBuffer bf = new StringBuffer();
      for(int i = 0; i < count; i++){
         bf.append(student[i]).append("~");
      }
      return bf.toString();
   }
}//end of class