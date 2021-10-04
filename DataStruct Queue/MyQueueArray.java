/**
   MyQueueArray
   -Jayharron
**/
public class MyQueueArray implements MyQueue{
   //data container
   private Object[] queue;
   //utility attributes
   private int head, tail;
   
   //constructors
   public MyQueueArray(int size){
      this.queue = new Object[size];
   }
   public MyQueueArray(){
      this(10);
   }
   //sentinel methods
   public boolean isFull()       {  return tail == queue.length;}
   public boolean isEmpty()      {  return tail == 0;}
   //allowable operations
   public boolean enqueue(Object item){
      boolean ok=!isFull();
         if(ok)   queue[tail++] = item;
      return ok;
   }
   public Object peek()          {  return (!isEmpty())?queue[head]:null;}
   public Object dequeue(){
      Object item = peek();
         if(item!=null){
            for(int i = head; i<tail;queue[i]=queue[i+1],i++);
            tail--;
         }
      return item;
   }
   //utility methods
   public void clear()           {  for(;!isEmpty();dequeue());}
   public int size()             {  return tail;}
   //override the tostring method
   public String toString(){
      StringBuffer sb = new StringBuffer();
         for(int i = head; i < tail;sb.append(queue[i]),i++);
      return sb.toString();
   }

}//end of class