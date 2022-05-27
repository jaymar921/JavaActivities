public class caesarCipher{
   public static void main(String... args){
      char letters[] = "abcdefghijklmnopqrstuvwxyzklmnopqrstuvwxyzabcdefghij".toCharArray();
      
      char[] message = "house".toCharArray();
      
      StringBuilder caesar = new StringBuilder();
      
      for(char x : message){
         for(int i = 0; i < letters.length; i++){
            if(x == letters[i]){
               caesar.append(letters[i+10]);
               break;
            }
            if(x == ' '){
               caesar.append(" ");
               break;
            }
         }
         
         System.out.println(caesar);
      }
   }
}