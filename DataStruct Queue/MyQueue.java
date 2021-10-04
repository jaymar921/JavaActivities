/**
   My Queue Interface
   -Jayharron
**/
public interface MyQueue{
   //sentinel methods
   public boolean isFull();
   public boolean isEmpty();
   //allowable operations
   public boolean enqueue(Object item);
   public Object peek();
   public Object dequeue();
   //utility methods
   public void clear();
   public int size();
}//end of interface