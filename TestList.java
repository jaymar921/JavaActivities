/**
   Abejar, Jayharron Mar Canillo
   BSIT - 2
   TEST CLASS FOR MYLISTARRAY AND MYLIST
**/
public class TestList{
   
   static public void main(String... args){
      MyList list = new MyListArray();
      
      list.addItem(new String("A"));
      list.addItem(new String("B"));
      list.addItem(new String("C"));
      list.addItem(new String("D"));
      list.addItem(new String("E"));
      list.addItem(new String("F"));
      
      System.out.println(list);
      System.out.println("Remove B: "+ list.removeItem(new String("B")));
      list.removeItem(new String("B"));
      System.out.println(list);
      System.out.println("Insert Before C new item X: "+ list.insertBefore(new String("C"), new String("X")));
      System.out.println(list);
   }
}
