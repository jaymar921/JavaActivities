public class MyStackArray implements MyStack{
   //define the data container
   private Object[] stack;
   private int top;
   
   //constructors
   public MyStackArray(int size)          { this.stack = new Object[size];}
   public MyStackArray()                  { this(10);} //set default size
   
   //Sentenel Methods
   public boolean isFull()                { return top == stack.length; }
   public boolean isEmpty()               { return top==0; }
   //allowable operations
   public boolean push(Object item){
      boolean ok=!isFull();
         if(ok)   stack[top++] = item;
      return ok;
   }
   public Object peek(){
      // Object item = null;
      // if(!isEmpty()) item = stack[count-1];
      // return item;
      return (!isEmpty())?stack[top-1]:null;
   }
   public Object pop(){
      Object item = peek();
         if(item!=null) stack[--top] = null;
      return item;
   }
   //non-essential methods
   public void clear(){
      for(;!isEmpty();pop());
   }
   public int count(){
      return top;
   }
   //to String
   public String toString(){
      StringBuffer sb = new StringBuffer();
         for(int i = top-1; i>-1; i--){
            sb.append(stack[i]);
         }
      return sb.toString();   
   }

}//end of class