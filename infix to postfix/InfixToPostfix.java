/**
   Jayharron Mar Abejar
   BSIT 2
   
   INFIX TO POSTfix
*/
public class InfixToPostfix{
   //declare the variable
   private String infix;
   //constructor
   public InfixToPostfix(String infix){
      this.infix=infix;
   }
   //utility methods
   private boolean isOperator(char c)  { return c=='*' || c=='+' || c=='-' || c=='/'; }
   private boolean isSpace(char c)     { return c==' ';}
   private boolean isLowerPrecedence(char a,char b){
      // '*' and '/' are always the highest precedence
      // '*' and '/' have equals precedence
      // '+' and '-' are always lower precedence to '*' or '/'
      // '+' and '-' have equal precedence
      switch(a){
         case '+': case '-': return !(b=='+' || b=='-');
      }
      return false;
   }
   //conversion method
   public String convert(){
      StringBuffer postfix=new StringBuffer();
      MyStack stack=null;
         //validate first
         if(infix!=null){
            java.util.StringTokenizer st=new java.util.StringTokenizer(infix,"-/*+",true);
            stack=new MyStackArray(infix.length());
            while(st.hasMoreTokens()){
               String token=st.nextToken();
               char c=token.charAt(0);
               if(isOperator(c)){
                  while(!stack.isEmpty() && !isLowerPrecedence(stack.peek().toString().charAt(0),c)){
                     postfix.append(stack.pop()).append(" ");
                  }
                  stack.push(c);
               }
               else postfix.append(token).append(" ");
            }
            //pop all from stack and put it on the postfix string
            for(;!stack.isEmpty();postfix.append(stack.pop()).append(" "));
         }
      return postfix.toString();
   }
   //
   public double compute(){
      double result=0.0;
      MyStack stack = null;
      String postfix = convert();
      
      if(postfix!=null){
         stack = new MyStackArray(postfix.length());
         java.util.StringTokenizer st = new java.util.StringTokenizer(postfix, "-+/* ", true);
         
         while(st.hasMoreTokens()){
            String token = st.nextToken();
            char c = token.charAt(0);
            
            if(isOperator(c)){
               double right = Double.parseDouble(stack.pop().toString());
               double left = Double.parseDouble(stack.pop().toString());
               
               switch(c){
                  case '-': result = left - right; break;
                  case '+': result = left + right; break;
                  case '*': result = left * right; break;
                  case '/': result = left / right;
               }
               stack.push(result);
            }
            else{
               if(!isSpace(c))
                  stack.push(token);
            }
         }
      }
      
      return result; // return
   }
   //
   static public void main(String... args){
      String infix = "((2+4)*5)-((4-2)/5)";
      InfixToPostfix itf=new InfixToPostfix(infix);
      System.out.println("Infix   :"+infix);
      System.out.println("Postfix :"+itf.convert()); 
      System.out.println("Compute :"+itf.compute());
   }
}//end of class