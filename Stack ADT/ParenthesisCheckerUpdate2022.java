public class ParenthesisCheckerUpdate2022{
   
   static MyStack stack = new MyStackLinked();
   static public void main(String... args){
      
      //open a file to check the content
      try{
         java.util.Scanner scan=new java.util.Scanner(new java.io.File("paren.txt"));
         String item=null;        
         while((item=scan.nextLine())!=null){
         
            System.out.print(item);
            char[] items=item.toCharArray();
            for(char c:items){ //here is my code
               
               if((c == ')' || c == '>' || c == ']' || c == '}') && stack.isEmpty()){
                  stack.push(c);
               }else if(c == '(' || c == '<' || c == '[' || c == '{'){
                  stack.push(c);
               }
               
               if(!stack.isEmpty()){
                  if(c == ')'){
                     if((char)stack.peek() == '('){
                        stack.pop();
                     }else
                        stack.push(c);
                  }else if(c == '>'){
                     if((char)stack.peek() == '<'){
                        stack.pop();
                     }else
                        stack.push(c);
                  }else if(c == ']'){
                     if((char)stack.peek() == '['){
                        stack.pop();
                     }else
                        stack.push(c);
                  }else if(c == '}'){
                     if((char)stack.peek() == '{'){
                        stack.pop();
                     }else
                        stack.push(c);
                  }

               }
            }
            if(stack.isEmpty()){
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
   
}//end of class