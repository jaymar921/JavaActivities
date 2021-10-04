public class MySetTest{
//main
   static public void main(String... args){
      MySet a = new MySetLinked(new String[]{"a","b","c","d","e"});
      MySet b = new MySetLinked(new String[]{"d","e","f","g"});
      
      System.out.println("SET A: "+a);
      System.out.println("SET B: "+b);
      
      System.out.println("SET AUB: "+a.union(b));
      System.out.println("SET A^B: "+a.intersect(b));
      System.out.println("SET A-B: "+a.subtract(b));
      System.out.println("SET B-A: "+b.subtract(a));
      System.out.println("SET AxB: "+a.crossProduct(b));
   }

}//end of class