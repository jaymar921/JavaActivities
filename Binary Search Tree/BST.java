/**
   Abejar, Jayharron Mar C
*/
import java.util.LinkedList;
import java.util.Queue;
public class BST{
   //define tree structure
   private Object item;
   private BST left,right,parent;
   
   //constructor
   public BST(Object item){
      this.item=item;
   }
   public BST(String[] items,BST root){
      for(String s:items)
         root=addTree(s,root);
   }
   
   //default constructor
   public BST(){}
   //define setters, getters
   public Object getItem() { return item;}
   public BST getLeft()    { return left;}
   public BST getRight()   { return right;}
   public BST getParent()  { return parent;}
   //
   public void setItem(Object item)    { this.item=item; }
   public void setLeft(BST left)       { this.left=left; }
   public void setRight(BST right)     { this.right=right; }
   public void setParent(BST parent)   { this.parent=parent; }
   //utility methods
   public BST addTree(Object item,BST root){
      BST tree=new BST(item);
      if (root==null) root=tree;
      else{
         Comparable c=(Comparable)item;
            if(c.compareTo(root.getItem())>0){
               root.setRight(root.addTree(item,root.getRight()));
            }
            else{
               if(c.compareTo(root.getItem())<0){
                  root.setLeft(root.addTree(item,root.getLeft()));
               }
            }
      }
      return root;   //return an updated root
   }
   //
   public void preOrder(BST root){
      if(root!=null){
         System.out.print(root.getItem());
         preOrder(root.getLeft());
         preOrder(root.getRight());
      }
   }
   //
   public void inOrder(BST root){
      if(root!=null){
         inOrder(root.getLeft());
         System.out.print(root.getItem());
         inOrder(root.getRight());
      }
   }
   //
   public void postOrder(BST root){
      if(root!=null){
         postOrder(root.getLeft());
         postOrder(root.getRight());
         System.out.print(root.getItem());
      }
   }
   //
   public void levelOrder(BST root){
   /**
      Sir here is my explaination
      pag first ga libog jud ko kay ako gi recursive then sayup ko kadaghan, dayun
      ni tan.aw ko youtube for reference...
      
      So ang nahintabo is gi kuha nako ang parent then gi put sa queue
      Dayun gi poll/remove/pop/dequeue nako ang element from queue ug gi store sa temporary BST
      
      kung ang katung temporary value naay left, e store ang left sa queue
      kung ang temporary value naay right, e store ang right sa queue
      
      Sir since ni tudlo man kag queue namo, ako gi implement to para ma gamit pud :)
   **/
      if(root!=null){
         MyQueue q = new MyQueueList(); // I implemented queue
         q.enqueue(root);                          //adding the first element to the queue
         BST Temp = null;                       //creating a null Temporary BST
         while(!q.isEmpty()){ 
            Temp = (BST)q.peek();                    //getting the element in queue and store it in temporary BST
            System.out.print(Temp.getItem());   //printing the value of the temporary element in BST
            if(Temp.getLeft()!=null)            //if current binary tree has left
               q.enqueue(Temp.getLeft());           //add left element to the queue
            if(Temp.getRight()!=null)           //if current binary tree has right
               q.enqueue(Temp.getRight());          //add right element to the queue
            q.dequeue();                        //remove the front of the queue
         }
         
      }
   }   
   
   //
   static public void main(String... args){
      //String[] items={"5","1","4","3","2","8","7","0"};
      BST root=null;
         root=new BST().addTree("B",root);
         root=new BST().addTree("L",root);
         root=new BST().addTree("U",root);
         root=new BST().addTree("E",root);
         root=new BST().addTree("P",root);
         root=new BST().addTree("R",root);
         root=new BST().addTree("I",root);
         root=new BST().addTree("N",root);
         root=new BST().addTree("T",root);
         root=new BST().addTree("S",root);
       
      System.out.print("Pre-Order :"); new BST().preOrder(root);
      System.out.print("\nIn-Order :");  new BST().inOrder(root);
      System.out.print("\nPost-Order :"); new BST().postOrder(root);
      System.out.print("\nLevel-Order :"); new BST().levelOrder(root);
   }
   
}//end of class
