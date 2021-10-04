/**
   MyNode class
   - serves as the data container of the Linked List
*/
public class MyNode{
   //define data container
   private Object item;
   //define the connection variable for the next MyNode link
   private MyNode next;
   
   //constructor
   public MyNode(Object item)          { this.item=item; }
   //default constructor
   public MyNode()                     {}
   //setters
   public void setItem(Object item)    { this.item=item; }    
   public void setNext(MyNode next)    { this.next=next; }
   //getters
   public Object getItem()             { return item; }
   public MyNode getNext()             { return next; }

}//end of class