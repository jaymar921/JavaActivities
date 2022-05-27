public class test_stack{

   public static void main(String... args){
      Stack stack = new Stack();
      
      System.out.println("Pushing 10, 25 and 3 into the stack class");
      stack.push(10);
      stack.push(25);
      stack.push(3);
      
      System.out.println("Display the elements");
      stack.displayElements();
      
      System.out.println("\nPop: "+stack.pop());
      System.out.println("\nDisplay the elements");
      stack.displayElements();
      System.out.println("\nTop: "+stack.topElement());
      System.out.println("Bottom: "+stack.bottomElement());
      
      System.out.println("\npush 105 and 206 into the stack");
      stack.push(105);
      stack.push(206);
      System.out.println("\nDisplay the elements");
      stack.displayElements();
   }
}

// simple/basic stack class
class Stack{
   // array of integers that will store the data
   private int[] data;
   // position of element
   private int position = 0;
   
   // custom constructor
   public Stack(int size){
      data = new int[size];
   }
   // default constructor
   public Stack(){
      this(10); // default size of 10
   }
   
   // add item or data into the stack
   public void push(int item){
      data[position++] = item;
   }
   
   // remove the item or data from the stack, returns the removed item or data
   public int pop(){
      return data[--position];
   }
   
   // display the top element/item
   public int topElement(){
      return data[position-1];
   }
   
   // display the bottom element/item
   public int bottomElement(){
      return data[0];
   }
   
   // print the elements from the stack, from top to bottom
   public void displayElements(){
      System.out.println("There are "+position+" elements");
      for(int x = position-1; x >= 0; x--){
         System.out.println(data[x]);
      }
   }
  
}