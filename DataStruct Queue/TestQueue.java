/**
   TestQueue
   -Jayharron
**/
public class TestQueue{
   static public void main(String... args){
      MyQueue q = new MyCircularQueue(5);
      
      q.enqueue(new String("A"));
      System.out.println(q);
      q.enqueue(new String("B"));
      System.out.println(q);
      q.enqueue(new String("C"));
      System.out.println(q);
      q.enqueue(new String("D"));
      System.out.println(q);
      q.enqueue(new String("E"));
      System.out.println(q);
      System.out.println("Dequeue: " + q.dequeue());
      System.out.println(q);
      System.out.println("Dequeue: " + q.dequeue());
      System.out.println(q);
      System.out.println("Dequeue: " + q.dequeue());
      System.out.println(q);
      q.enqueue(new String("F"));
      System.out.println(q);

   }
}//end of class