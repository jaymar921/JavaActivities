public class tester{
   static public void main(String... args){
      String[] items={"5","1","4","3","2","8","7","0"};
      BST root=null;
         root=new BST().addTree("D",root);
         root=new BST().addTree("E",root);
         root=new BST().addTree("M",root);
         root=new BST().addTree("O",root);
         root=new BST().addTree("G",root);
         root=new BST().addTree("R",root);
         root=new BST().addTree("A",root);
         root=new BST().addTree("P",root);
         root=new BST().addTree("H",root);
         root=new BST().addTree("Y",root);
       
      System.out.print("Pre-Order :"); new BST().preOrder(root);
      System.out.print("\nIn-Order :");  new BST().inOrder(root);
      System.out.print("\nPost-Order :"); new BST().postOrder(root);
      System.out.print("\nLevel-Order :"); new BST().levelOrder(root);
   }
}