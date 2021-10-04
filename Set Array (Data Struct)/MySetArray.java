/**
   MySetArray - an array implementation of the MySet ADT
**/
public class MySetArray implements MySet{
   //data containers
   private Object[] setItem;
   private int count, position;
   
   //constructor
   public MySetArray(int size)         {  this.setItem = new Object[size];}
   public MySetArray()                 {  this(10);}
   public MySetArray(String s){
      if(!s.equals("")){
         setItem = s.split(",");
         count=setItem.length;
      }
   }
   
   //sentinel methods
   public boolean isFull()             {  return count==setItem.length;}
   public boolean isEmpty()            {  return count==0;}
   //utility methods
   public boolean addItem(Object item){
      //we cannot add an existing element
      boolean ok=!isItem(item);
         if(ok)   setItem[count++] = item;
      return ok;
   }
   public boolean isItem(Object item){
      //implement a sequential search operation
      boolean found = false;
         for(int i=0;i<count;i++){
            if(setItem[i].equals(item)){
               found = true;
               position = i;
               break;
            }
         }
         return found;
   }
   //allowable operations
   public MySet union(MySet set){
      MySetArray params = (MySetArray)set;         // <- params is from the parameter set
      String items = params.toString();            // <- items is the converted string from param set
      // parI will be the elements inside the params set
      // remember that the size of parI is set to items.length which will cause space inside the array to have a null
      String[] parI = new String[items.length()];  
      int index = 0; // <- index will be used as the size of the paramItems[], it is also used in the string tokenizer
      java.util.StringTokenizer st = new java.util.StringTokenizer(items,"{},"); // <- I separate the items by { } ,
      while(st.hasMoreTokens()){
         parI[index++] = st.nextToken(); // <- adding item inside the parI, remember that there is still extra slots which will be causing a null pointer
      }
      String[] paramItems = new String[index]; // <- now I create the paramItems which the index will be the total elements of the param set
      int ct = 0; // <- ct will be the index counter for the paramItems
      for(String a : parI){
         paramItems[ct++] = a;   //<- adding items inside the paramItems
         if(ct==index)  break;   //<- if ct == index, the loop break to avoid putting null inside the paramItems array
      }
      
      MySet result = new MySetArray(cardinality() + params.cardinality());
      //the actual solution from sir Durano
      //populate the set, remember, sets are unordered
      
      for(int i = 0; i < count; result.addItem(setItem[i]),i++);
      for(int i = 0; i < paramItems.length; i++) {result.addItem(paramItems[i]);}
      
      return result;
   }
   public MySet intersect(MySet set){
      MySetArray params = (MySetArray)set;         // <- params is from the parameter set
      String items = params.toString();            // <- items is the converted string from param set
      // parI will be the elements inside the params set
      // remember that the size of parI is set to items.length which will cause space inside the array to have a null
      String[] parI = new String[items.length()];  
      int index = 0; // <- index will be used as the size of the paramItems[], it is also used in the string tokenizer
      java.util.StringTokenizer st = new java.util.StringTokenizer(items,"{},"); // <- I separate the items by { } ,
      while(st.hasMoreTokens()){
         parI[index++] = st.nextToken(); // <- adding item inside the parI, remember that there is still extra slots which will be causing a null pointer
      }
      String[] paramItems = new String[index]; // <- now I create the paramItems which the index will be the total elements of the param set
      int ct = 0; // <- ct will be the index counter for the paramItems
      for(String a : parI){
         paramItems[ct++] = a;   //<- adding items inside the paramItems
         if(ct==index)  break;   //<- if ct == index, the loop break to avoid putting null inside the paramItems array
      }
      int size = (cardinality()<params.cardinality())?cardinality():params.cardinality();
      MySet result = new MySetArray(size);
      
      for(int i = 0; i < params.cardinality();i++){
         if(isItem(parI[i]))
            result.addItem(parI[i]);
      }
      return result;
   }
   public MySet subtract(MySet set){
      MySetArray params = (MySetArray)set;         // <- params is from the parameter set
      String items = params.toString();            // <- items is the converted string from param set
      // parI will be the elements inside the params set
      // remember that the size of parI is set to items.length which will cause space inside the array to have a null
      String[] parI = new String[items.length()];  
      int index = 0; // <- index will be used as the size of the paramItems[], it is also used in the string tokenizer
      java.util.StringTokenizer st = new java.util.StringTokenizer(items,"{},"); // <- I separate the items by { } ,
      while(st.hasMoreTokens()){
         parI[index++] = st.nextToken(); // <- adding item inside the parI, remember that there is still extra slots which will be causing a null pointer
      }
      String[] paramItems = new String[index]; // <- now I create the paramItems which the index will be the total elements of the param set
      int ct = 0; // <- ct will be the index counter for the paramItems
      for(String a : parI){
         paramItems[ct++] = a;   //<- adding items inside the paramItems
         if(ct==index)  break;   //<- if ct == index, the loop break to avoid putting null inside the paramItems array
      }
      int size = (cardinality()<params.cardinality())?cardinality():params.cardinality();
      MySet result = new MySetArray(size);
      
      for(int i = 0; i < params.cardinality();i++){
         if(!isItem(parI[i]))
            result.addItem(parI[i]);
      }
      return result;
   }
   public MySet crossProduct(MySet set){
      MySetArray params = (MySetArray)set;         // <- params is from the parameter set
      String items = params.toString();            // <- items is the converted string from param set
      // parI will be the elements inside the params set
      // remember that the size of parI is set to items.length which will cause space inside the array to have a null
      String[] parI = new String[items.length()];  
      int index = 0; // <- index will be used as the size of the paramItems[], it is also used in the string tokenizer
      java.util.StringTokenizer st = new java.util.StringTokenizer(items,"{},"); // <- I separate the items by { } ,
      while(st.hasMoreTokens()){
         parI[index++] = st.nextToken(); // <- adding item inside the parI, remember that there is still extra slots which will be causing a null pointer
      }
      String[] paramItems = new String[index]; // <- now I create the paramItems which the index will be the total elements of the param set
      int ct = 0; // <- ct will be the index counter for the paramItems
      for(String a : parI){
         paramItems[ct++] = a;   //<- adding items inside the paramItems
         if(ct==index)  break;   //<- if ct == index, the loop break to avoid putting null inside the paramItems array
      }
      int size = cardinality()*params.cardinality();
      MySet result = new MySetArray(size);
      
         for(int i = 0; i < cardinality();i++){
            for(int j = 0; j < paramItems.length; j++){
               MySet temp = new MySetArray(2);
               temp.addItem(setItem[i]);
               temp.addItem(paramItems[j]);
               if(temp.cardinality()==2)
                  result.addItem(temp);
            }
         }
      
      return result;
   }
   
   public int cardinality(){
      return count;
   }
   
   //toString 
   public String toString(){
      StringBuffer sb = new StringBuffer();
      sb.append("{");
         for(int i = 0; i < count; i++){
            sb.append(setItem[i]);
            if(i<count-1)
               sb.append(",");
         }
      sb.append("}");
      return sb.toString();
   }
   
   //main
   static public void main(String... args){
      MySet a = new MySetArray("a,b,c,d,e");
      MySet b = new MySetArray("d,e,f,g");
      
      System.out.println("SET A: "+a);
      System.out.println("SET B: "+b);
      
      System.out.println("SET AUB: "+a.union(b));
      System.out.println("SET A^B: "+a.intersect(b));
      System.out.println("SET A-B: "+b.subtract(a));
      System.out.println("SET B-A: "+a.subtract(b));
      System.out.println("SET AxB: "+a.crossProduct(b));
   }

}//end of class