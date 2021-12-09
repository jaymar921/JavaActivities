import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
public class readFile{

   public static void main(String... args){
      read("hello.txt"); //call the read method and passing the file name param
   }
  
   private static void read(String filename){
      try{
         File file = new File(filename);
         InputStream input = new FileInputStream(file);
         int i;
         while((i = input.read())!=-1){
            System.out.print((char)i);
         }
      }catch(IOException error){}
   }
}
