/**
   Simple Linked List 
*/
public class SimpleLinkedList{
   //first requirement, there must be a MyNode class within the folder(package)
   private MyNode head; //mark the beginning of the Linked List
   private MyNode tail; //mark the end of the Linked List
   //sentinel method
   public boolean isEmpty(){
      return head==null && tail==null;
   }
   
   //linked-list implemented ADT, constructors are optional
   public boolean addNode(Object item){
      MyNode node=new MyNode(item); //create an instance of MyNode and put the data item
         if(isEmpty())     head=node;
         else              tail.setNext(node);   
            tail=node;
      return true;
   }
   //display the content of the Linked-List
   public void displayList(){
      //create traversing node- a node pointer that moves across the structure
      //we can only display the list if the list is not empty
      if(!isEmpty()){
         MyNode tnode=head; //set the traversing node at the head(1st element of the LL)
         //loop across the list
         for(;tnode!=null;tnode=tnode.getNext()){
            System.out.print(tnode.getItem());
         }
      }
   }
   //
   static public void main(String... args){
      SimpleLinkedList l=new SimpleLinkedList();
         l.addNode(new String("A"));
         l.addNode(new String("B"));
         l.addNode(new String("C"));
         l.addNode(new String("D"));
         l.addNode(new String("E"));
         l.displayList();
   }
}//end of class