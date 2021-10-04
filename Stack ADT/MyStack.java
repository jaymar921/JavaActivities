public interface MyStack{
   //Sentenel Methods
   public boolean isFull();
   public boolean isEmpty();
   //allowable operations
   public boolean push(Object item);
   public Object peek();
   public Object pop();
   //non-essential methods
   public void clear();
   public int count();

}//end of interface