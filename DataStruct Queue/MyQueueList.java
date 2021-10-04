/**
   MyQueueList
   -Jayharron
**/
public class MyQueueList implements MyQueue{
   //data container
   private MyNode head, tail;
   //utility variable
   private int count;
   
   //constructor is not required
   
   //sentinel methods
   public boolean isFull()                {  return false;}
   public boolean isEmpty()               {  return count == 0;}
   //allowable operations
   public boolean enqueue(Object item){
      //create an instance of mynode class,set the item as the data
      MyNode node = new MyNode(item);
      if(isEmpty())    head = node;
      else              tail.setNext(node);
         tail = node;
         count++;
      return true;
   }
   public Object peek()                   {  return (!isEmpty())?head.getItem():null;}
   public Object dequeue(){
      Object item = peek();
      if(item!=null){
         MyNode node = head;
         head = node.getNext();
         node = null;
         count--;
      }
      return item;
   }
   //utility methods
   public void clear()                    {  for(;!isEmpty();dequeue());}
   public int size()                      {  return count;}
   
   //override the toString Method
   public String toString(){
      StringBuffer sb = new StringBuffer();
         for(MyNode node = head; node!=null;sb.append(node.getItem()),node = node.getNext());
      return sb.toString();
   }

}//end of class