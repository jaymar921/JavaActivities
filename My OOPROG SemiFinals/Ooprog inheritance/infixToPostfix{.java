public class InfixToPostfix{
   //declare the variable
   private String infix;
   //constructor
   public InfixToPostfix(String infix){
      this.infix=infix;
   }
   //utility methods
   private boolean isOperator(char c)  { return c=='*' || c=='+' || c=='-' || c=='/'; }
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
                     postfix.append(stack.pop());
                  }
                  stack.push(c);
               }
               else postfix.append(token);
            }
            //pop all from stack and put it on the postfix string
            for(;!stack.isEmpty();postfix.append(stack.pop()));
         }
      return postfix.toString();
   }
   //
   public double compute(String postfix){
      double result=0.0;
      //you cannot compute if no postfix string
      //
      
      //Sir this is my attributes
      MyStack stack = new MyStackArray(10);  // <- this is the stack, diri ma store ang mga numeric values
      String[] element = new String[10];    //  <- array of string
      int count = 0;                         // <- count increment use for string array
      double res = 0.0;                      // < stores temporary result
      double right = 0;                      // <- stores the first pop from the stack
      double left = 0;                       // < - stores the 2nd pop from the stack
      char op = '\u0000';                    // <- initialize op as null character
      java.util.StringTokenizer st=new java.util.StringTokenizer(postfix,"1234567890-/*+",true);
      while(st.hasMoreTokens()){
         element[count++] = st.nextToken(); // in this loop, i convert the postfix string to string array
      }
      try{
      for(String s : element){         //I loop it using for each loop
         
         if(isOperator(s.charAt(0))){  // if the s from the element array is an operator, this block will be used
            op = s.charAt(0);       // I set the op to the s.charAt(0)
            res = 0.0;              //set res to 0
            
            //the reason na dugay ko kay wala ko kabalo unsaon pag 
            //convert sa object padulong sa double
            //pero na notice nako na pwede ra e convert kung ipa agi ang object didto sa string dayun sa double
            right = Double.valueOf(stack.pop().toString()); // I get the value of the first pop
            left = Double.valueOf(stack.pop().toString());  // I get the value of the 2nd pop
            //diri ma hintabo ang pag add, minus, times ug divide
            if(op == '+')
               res = left + right;
            else if(op == '-')
               res = left - right;
            else if(op == '*')
               res = left * right;
            else if(op == '/')
               res = left / right;
               
            stack.push(res); //ang result kay e push nako sa stack para sunod gamiton nasad
         }else //kung ang s kay dili operator means ang s kay operands
         stack.push(s); // <- e push nako ang operands sa stack
      }
      
      }catch(Exception e){}
      result = Double.valueOf(stack.pop().toString()); //gi get nako ang last sulod sa stack
      return result; // return
   }
   //
   static public void main(String... args){
      InfixToPostfix itf=new InfixToPostfix("1-2*3+4/5");
      String postfix = itf.convert();
      System.out.println("Postfix :"+postfix); 
      System.out.println("Compute :"+itf.compute(postfix));
   }
}//end of class