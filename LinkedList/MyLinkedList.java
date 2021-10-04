/**
   ABEJAR, JAYHARRON MAR C.
   BSIT - 2, DATA STRUCT
   
   Sir I put explaination but I hope you understand,
   I just want to share what I learned and explain it through documentation
   
   
   MyLinkedList - is the Linked-List implementation of the MyList ADT
*/
public class MyLinkedList implements MyList{
 
   //first requirement, there must be a MyNode class within the folder(package)
   private MyNode head; //mark the beginning of the Linked List
   private MyNode tail; //mark the end of the Linked List
   // create utility variable
   
   private MyNode position; //mark the position of the linked List
   private int count; //monitor the actual number of elements in the list
   private Object isItem; //mark the item in the linked list for reference
   
   
   //linked-list implemented ADT, constructors are optional
   public boolean isFull(){
      //your code here
      return false;
   }
   public boolean isEmpty(){
      //your code here
      return head == null && tail == null;
   }
   //allowable operations
   public boolean addItem(Object item){
      //your code here
       MyNode node=new MyNode(item); //create an instance of MyNode and put the data item
         if(isEmpty())     head=node;
         else              tail.setNext(node);   
            tail=node;
         count++;
      return true;
   }
   public boolean isItem(Object item){
      if(!isEmpty()){
         MyNode tnode=head; //set the traversing node at the head(1st element of the LL)

         //loop across the list
         for(;tnode!=null;tnode=tnode.getNext()){
            if(tnode.getItem().equals(item)){
               position = tnode;
               return true;
               }
         }
      }
      return false;
   }
   
   //remove item
   public boolean removeItem(Object item){
   boolean ok = isItem(item);
      if(!isEmpty() && ok){
         
         MyNode tnode = head; //traversing node at the head
         MyNode unode = head; //this will be the followup the traversing node

         
         for(MyNode positionNode = head;positionNode!=null;positionNode=positionNode.getNext()){
            unode = positionNode.getNext(); //set the unode 1 step forward 
            tnode = positionNode;           //set the tnode at the same location as positionNode in forloop
            
            /**
            Di ko kabalo mo explain sir but this is what I meant
                  Elements 
                              position
                                 v
                           A     B     C     D     E     F
                           ^     ^
                         tnode  unode
            **/
            
            if(head == position){ //if position is in head, the new head will become the unode, then removing the head from the list
               head = unode;
               count--;
            }else if(unode == position){//check if unode found the position
               if(unode.getNext() != null){ //if unode has next (means that if unode is not a tail)
                  tnode.setNext(unode.getNext());  //the next of the tnode will be the next of unode
                  /**
                     if ang position is letter E, ang pointer sa E which is si F kay ma adto ni D,
                     therefor ang new pointer ni D is si F, and si E is ma wala sa list
                      Elements 
                                                position
                                                   v
                           A     B     C     D     E     F
                                             ^     ^
                                          tnode  unode

                  **/
                  count--;
               }else{
               //if position is found at the tail, it points to null 
                  tnode.setNext(null);
                  tail = tnode;
                  count--;
               }
               unode = null;
            }
            
         }
      }
      return ok;
   }
   public boolean insertBefore(Object item,Object newitem){
      //your code here
      boolean ok = isItem(item);
         MyNode node=new MyNode(newitem); //create an instance of MyNode and put the data item

         if(!isEmpty() && ok){
            MyNode tnode = head; //traversing node at the head
            MyNode unode = head; //this will be the followup the traversing node
            MyNode newNode = node; //this is the new item added in the list to be inserted before the selected item
         
             for(MyNode positionNode = head;positionNode!=null;positionNode=positionNode.getNext()){
               unode = positionNode.getNext(); 
               tnode = positionNode;
               
               //it is the same logic with remove item but instead of removing the element from the list
               //I add the new element before the item position
               
               if(head == position){ //if the position is found on head
                  newNode.setNext(head); //the new item pointer will point to the previous head
                  head = newNode;        //the new head will be the newNode added
                  count++;
                  break;
               }else if(unode == position){ //if unode found the position
                  tnode.setNext(newNode);   //the tnode will set its pointer to the newNode
                  newNode.setNext(unode);   //the newNode will set its pointer to the unode
                  count++;
                  break;
               }
                          
            
             }

         }
         
      return ok;
   }
   public boolean insertAfter(Object item,Object newitem){
      boolean ok = isItem(item);
         MyNode node=new MyNode(newitem); //create an instance of MyNode and put the data item

         if(!isEmpty() && ok){
            MyNode tnode = head; //traversing node at the head
            MyNode unode = head; //this will be the followup the traversing node
            MyNode newNode = node; //this is the new item added in the list to be inserted before the selected item
         
             for(MyNode positionNode = head;positionNode!=null;positionNode=positionNode.getNext()){
               unode = positionNode.getNext(); 
               tnode = positionNode;
               
               if(tnode == position){     //if tnode found the position
                  tnode.setNext(newNode); //tnode will set its pointer to the newNode
                  newNode.setNext(unode); //then the new node will set its pointer to the unode
                  if(position == tail)    //if position is found at the tail
                     addItem(newitem);      //the tail will be the newNode
                
                     
                  count++;
                  break;
               }
                          
            
             }

         }
         
      return ok;

   }
   
   
   public String toString(){
   StringBuffer buff = new StringBuffer();
   if(!isEmpty()){
         MyNode tnode=head; // this will find the head for the loop
         //loop across the list
         for(;tnode!=null;tnode=tnode.getNext()){
            buff.append(tnode.getItem());
               if(tnode.getNext()!=null)
                  buff.append(", ");
         }
      }
      return buff.toString();
   }

}//end of class
