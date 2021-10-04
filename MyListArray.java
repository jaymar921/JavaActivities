/**
   Abejar, Jayharron Mar
   BSIT - 2
   MyListArray
**/

public class MyListArray implements MyList{
   //data containers
   private Object[] items;
   //utility variables
   private int count;
   private int position;
   
   //constructors
   public MyListArray(int size)  { this.items = new Object[size];} //initiate the data container
   public MyListArray()          { this(10); } //default size

    //sentinel methods
   public boolean isFull()       { return count==items.length;}
   public boolean isEmpty()     { return count==0; }
   
   //allowable operations
   
   public boolean addItem(Object item){
      boolean ok=!isFull();
         if(ok) items[count++] = item;
      return ok;
   }
   public boolean isItem(Object item){
      boolean found = false;
         if(!isEmpty()){
            for(int i = 0; i < count; i++){
               if(item.equals(items[i])){
                  found = true;
                  position = i;
                  break;
               }
            }
         }
         return found;
   }
   public boolean removeItem(Object item){
      boolean ok=isItem(item) && !isFull();
      if(ok){
         for(int i = position; i < count; items[i]=items[i+1], i++);
         count--;  
      }
      return ok;
   }
   public boolean insertBefore(Object item, Object newitem){
      boolean ok = isItem(item) && !isFull();
      if(ok){
         for(int i = count; i >= position; items[i] = items[i-1], i--);
         items[position] = newitem;
         count++;
      }
      return ok;
   }
   public boolean insertAfter(Object item, Object newitem){
      boolean ok = isItem(item) && !isFull();
      if(ok){
         for(int i = count; i > position; items[i] = items[i-1], i--);
         items[position+1] = newitem;
         count++;
      }
      return ok;
   }
   //override the toString() method
   
   public String toSring(){
      StringBuffer bf = new StringBuffer();

         for(int i = 0; i < count; i++){
            bf.append(items[i]);

            if(i<count-1)
               bf.append(",");
         }
       
      return bf.toString();
   }

}// end of class