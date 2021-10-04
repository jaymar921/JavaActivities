/**
   MyStackLinked, Linked list implementation of MyStack ADT
**/
public class MyStackLinked implements MyStack{

   //define the data containers
   private MyNode top;
   private int count;
   
   //constructor is not essential
   //Sentenel Methods
   public boolean isFull()          {  return false; }//linked-list will not get full
   public boolean isEmpty()         {  return count == 0;}
   //allowable operations
   public boolean push(Object item){
      //create an instance of MyNode
      MyNode node = new MyNode(item);
      if(!isEmpty()) node.setNext(top);
         top = node;
      count++;
      return true;
   }
   public Object peek()             {  return (!isEmpty())?top.getItem():null;}
   public Object pop(){
      Object item = peek();
      MyNode node = top;
      if(item!=null){
         top = node.getNext();
         node = null;
         count--;
      }
      return item;
   }
   //non-essential methods
   public void clear(){
      for(;!isEmpty();pop());
   }
   public int count(){
      return count;
   }
   
   //override the toString() method
   public String toString(){
      StringBuffer sb = new StringBuffer();
         for(MyNode node = top; node!=null;sb.append(node.getItem()),node=node.getNext());
      return sb.toString();
   }

}//end of class