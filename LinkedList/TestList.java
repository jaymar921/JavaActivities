/**
   Abejar, Jayharron Mar Canillo
   BSIT - 2
   
**/
public class TestList{
   
   static public void main(String... args){
      MyList list = new MyLinkedList();
      
      list.addItem(new String("A"));
      list.addItem(new String("B"));
      list.addItem(new String("C"));
      list.addItem(new String("D"));
      list.addItem(new String("E"));
      list.addItem(new String("F"));

      

      System.out.println(list);
      System.out.println("Remove E: "+ list.removeItem(new String("E")));
      System.out.println(list);
      System.out.println("Insert Before F new item X: "+ list.insertBefore(new String("F"), new String("X")));
      System.out.println(list);
      System.out.println("Insert After C new item T: "+ list.insertAfter(new String("C"), new String("T")));
      System.out.println(list);



   }
}
