class node{
   node left, right;
   int data;
   
   public node(int value){
      this.data = value;
   }
   
   public void insert(int value){
      if(value <= data){
         if(left == null)
            left = new node(value);
         else
            left.insert(value);
      }else{
         if(right == null)
            right = new node(value);
         else
            right.insert(value);
      }
   }
   
   public boolean contains(int value){
      if(value == data)
         return true;
      else if (value < data){
         if(left == null)
            return false;
         else
            return left.contains(value);
      }else{
         if(right == null)
            return false;
         else
            return right.contains(value);
      }
   }
   
   public void inOrder(){
      if(left!=null)
         left.inOrder();
      System.out.print(data+" ");
      if(right!=null)
         right.inOrder();
   }
}

public class testTree{
   public static void main(String... args){
      node tree = new node(4);
      tree.insert(5);
      tree.insert(1);
      tree.insert(3);
      tree.insert(2);
      tree.insert(7);
      tree.insert(10);
      tree.insert(8);
      tree.insert(9);
      tree.insert(6);
      
      tree.inOrder();
   }
}