/**
   Abejar, Jayharron Mar C.
   BSIT - 2
   Parenthesis Checker
*/
public class ParenthesisCheck{

   static public void main(String... args){
      MyStack stack = new MyStackLinked();
      //open a file to check the content
      try{
         java.util.Scanner scan=new java.util.Scanner(new java.io.File("paren.txt"));
         String item=null; 
         int count = 0;
         char d = '\u0000';
         while((item=scan.nextLine())!=null){
 
            //System.out.print(item);
            char[] items=item.toCharArray();
            for(char c:items){ //here is my code
            
            
               if((c == ')' || c == '>' || c == ']' || c == '}') && stack.count() == 0){
                  stack.push(c);
               }else if(c == '(' || c == '<' || c == '[' || c == '{'){
                  stack.push(c);
               }
               
               if(stack.count()!=0){
                  if(c == ')'){
                     if((Character)stack.peek() == '('){
                        stack.pop();
                     }else
                        stack.push(c);
                  }else if(c == '>'){
                     if((Character)stack.peek() == '<'){
                        stack.pop();
                     }else
                        stack.push(c);
                  }else if(c == ']'){
                     if((Character)stack.peek() == '['){
                        stack.pop();
                     }else
                        stack.push(c);
                  }else if(c == '}'){
                     if((Character)stack.peek() == '{'){
                        stack.pop();
                     }else
                        stack.push(c);
                  }

               }

            /*
            d = items[++count];
            if(c=='('||c=='{'||c=='['||c=='<')   
               stack.push(new Character(c));
            
            if(stack.peek()!=null)
            if(d==')'||d=='}'||d==']'||d=='>') 
               stack.pop();
            
            System.out.print(stack);
            */
            }
            count = 0;
            System.out.print(items);
            if(stack.count() == 0){
               System.out.print(" - Balance\n");
            }else{
               System.out.println(" - Un-Balance\n");
            }
            
            stack.clear();
            //my code ends here
              // System.out.println(c);
         }
      }catch(Exception e){
         //e.printStackTrace();
      }
   }//end of main

}//end of class