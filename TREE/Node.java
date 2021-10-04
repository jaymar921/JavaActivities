// class to create nodes
class Node {
   String key;
   Node left, right;

   public Node(String item) {
      key = item;
      left = right = null;
   }
}

class BinaryTree {
   Node root;

   // Traverse tree
   public void traverseTree(Node node) {
      if (node != null) {
         traverseTree(node.left);
         System.out.print(" " + node.key);
         traverseTree(node.right);
      }
   }
   public void traverseTreePost(Node node) {
      if (node != null) {
         System.out.print(" " + node.key);
         traverseTree(node.left);
         
         traverseTree(node.right);
         //System.out.print(" " + node.key);
      }
   }

   public static void main(String[] args) {
   
      // create an object of BinaryTree
      BinaryTree tree = new BinaryTree();
   
      // create nodes of the tree
      tree.root = new Node("B");
      tree.root.left = new Node("L");
      tree.root.right = new Node("U");
      tree.root.left.left = new Node("E");
      tree.root.left.right = new Node("P");
      tree.root.right.left = new Node("R");
      tree.root.right.right = new Node("I");
      tree.root.left.left.left = new Node("N");
      tree.root.left.left.right = new Node("T");
      tree.root.left.right.left = new Node("S");
      
      
      System.out.print("\nBinary Tree: ");
      tree.traverseTreePost(tree.root);
      System.out.print("\n");
      tree.traverseTree(tree.root);
   }
}