import java.io.OutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
public class saveFile{

   public static void main(String... args){
      String data = """
      This is the data
      Name: JayMar921
      Age: 21
      """;
      write(data, "filename.txt");
   }
   
   private static void write(String data, String filename){
      try{
         File file = new File(filename);
         OutputStream output = new FileOutputStream(file);
         
         byte[] content = data.getBytes();
         output.write(content, 0, content.length);
         
         output.close();
         
      }catch(IOException error){}
   }

}
