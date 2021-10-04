/**
   Abejar, Jayharron Mar C.
   BSIT - 2
   Parenthesis Checker
*/
public class Parenthesis{
      static char[] stack = new char[30];
      static int top = 0;
   static public void main(String... args){
      
      //open a file to check the content
      try{
         java.util.Scanner scan=new java.util.Scanner(new java.io.File("paren.txt"));
         String item=null;        
         while((item=scan.nextLine())!=null){
            top = 0;
            System.out.print(item);
            char[] items=item.toCharArray();
            for(char c:items){ //here is my code
               
               if((c == ')' || c == '>' || c == ']' || c == '}') && top == 0){
                  push(c);
               }else if(c == '(' || c == '<' || c == '[' || c == '{'){
                  push(c);
               }
               
               if(top!=0){
                  if(c == ')'){
                     if(stack[top-1] == '('){
                        pop(c);
                     }else
                        push(c);
                  }else if(c == '>'){
                     if(stack[top-1] == '<'){
                        pop(c);
                     }else
                        push(c);
                  }else if(c == ']'){
                     if(stack[top-1] == '['){
                        pop(c);
                     }else
                        push(c);
                  }else if(c == '}'){
                     if(stack[top-1] == '{'){
                        pop(c);
                     }else
                        push(c);
                  }

               }
            }
            if(top == 0){
               System.out.print(" - Balance\n");
            }else{
               System.out.println(" - Un-Balance\n");
            }
            //my code ends here
              // System.out.println(c);
         }
      }catch(Exception e){
         //e.printStackTrace();
      }
   }//end of main
   
   //I added these push and pop method because it plays an important role in the STACK ADT
   
   //push method
   static void push(char c){
      stack[top] = c;
      top++;
   }
   //pop method
   static void pop(char c){
      stack[top] = '\u0000';
      top--;
   }
}//end of class