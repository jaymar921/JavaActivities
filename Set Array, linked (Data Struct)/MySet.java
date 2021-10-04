/**
   MYSET ADT(ABSTRACT DATA TYPE)
**/
public interface MySet{
   //sentinel methods
   public boolean isFull();
   public boolean isEmpty();
   //utility methods
   public boolean addItem(Object item);
   public boolean isItem(Object item);
   //allowable operations
   public MySet union(MySet set);
   public MySet intersect(MySet set);
   public MySet subtract(MySet set);
   public MySet crossProduct(MySet set);

}//end of interface