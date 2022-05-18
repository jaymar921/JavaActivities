import java.util.Random;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.GridLayout;
public class XMASSTREE extends JFrame{
   
   JLabel[] label = new JLabel[14];
   
   public XMASSTREE(){
      super("Merry Christmas");
      setVisible(true);
      setSize(500,400);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(14,1));
      for(int i = 0; i < 14; i++){
         label[i] = new JLabel("-");
         label[i].setHorizontalAlignment(JLabel.CENTER);
         label[i].setVerticalAlignment(JLabel.CENTER);
         label[i].setFont(new Font("Verdana", Font.BOLD, 18));
         add(label[i]);
      }
      
      //pack();
      //
      tree();
   }

   public void tree(){
   int gift_n = 0;
   for(;;){
 
      String bf = "";
      int rows = 0;
      int batch = 1;
      int leaves = 1;
      int loc = 0;
      int disp_n = 0;
      String[] ornaments = {"*", "@", "+", "-"};
      String[] gift = {"MERRY","CHRISTMAS"," "};
      
      for(;batch!=4;batch++){
         if(batch==2){
            leaves-=2;
         }
         if(batch==3){
            leaves-=4;
         }
         for(;rows<4;rows++){

            for(int x = 0; x < leaves; x++){
               if(Math.random() < 0.3)
                  bf += ornaments[new Random().nextInt(ornaments.length)];
               else
                  bf += ornaments[0];
               bf+=" ";
            }
            leaves+=2;
            label[disp_n++].setText(bf);
            bf="";
         }
         rows = 0;
      }
      for(int j = 0; j < 2; j++){
         label[disp_n++].setText("[][]");
         if(disp_n == label.length){
            bf = gift[gift_n++];
            label[disp_n-1].setText("["+bf+"]   [][]   ["+bf+"]");
            }
      }
      try{Thread.sleep(300);}catch(InterruptedException e){System.out.println(e);}  
      if(gift_n == 3)  gift_n = 0;
     }
   }
   
   public static void main(String... args){
      new XMASSTREE();
   }
}
