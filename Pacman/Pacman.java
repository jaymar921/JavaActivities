/**
   Jayharron Mar Abejar
   PacMan
**/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pacman extends JFrame{
   PacmanCanvas canvas;
   PacmanThread thread;
   
   //constructor
   public Pacman(){
      canvas = new PacmanCanvas(this);
      thread = new PacmanThread(canvas);
      //
      add(canvas);
      setTitle("MyPacman v1.0");
      setSize(400,400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   //launcher method
   static public void main(String... args){
      new Pacman();
   }

}//end of class
class PacmanCanvas extends Canvas{
   Pacman pacman;
   int x,y;    // <- position
   int startAngle,endAngle;
   int direction;
   
   //PacmanCanvas constructor
   public PacmanCanvas(Pacman pacman){
      this.pacman = pacman;
      startAngle = 30;
      endAngle = 300;
   }
   //paint method
   public void paint(Graphics g){
      g.setColor(Color.BLUE);
      g.fillRect(0,0,getWidth(),getHeight());
      //draw
      g.setColor(Color.YELLOW);
      g.fillArc(x,y,50,50,startAngle,endAngle);
   }
}//end of canvas
class PacmanThread implements Runnable{
   PacmanCanvas canvas;
   Thread t = null;
   //PacmanThread Constructor
   public PacmanThread(PacmanCanvas canvas){
      this.canvas = canvas;
      this.t = new Thread(this);
      this.t.start();
   }
   public void run(){
      for(;;){
      
         switch(canvas.direction){
            case 0:  //left to right
               if(canvas.x<canvas.getWidth()-50){
                  canvas.startAngle = 30;
                  canvas.endAngle = 300;
                  canvas.x+=3;
               }else canvas.direction = 1;
            break;
            case 1: //right to left
               if(canvas.y<canvas.getHeight()-50){
                  canvas.startAngle = 300;
                  canvas.endAngle = 290;
                  canvas.y+=3;
               } else canvas.direction = 2;
            break;
            case 2: //right to left
               if(canvas.x>0){
                  canvas.startAngle = 150;
                  canvas.endAngle = -300;
                  canvas.x-=3;
               } else canvas.direction = 3;
               break;
            case 3: //right to left
               if(canvas.y>0){
                  canvas.startAngle = 60;
                  canvas.endAngle = -300;
                  canvas.y-=3;
               } else canvas.direction = 0;

         
         }
      
      /*
         if(canvas.x<canvas.getWidth()-50){
            canvas.x+=3;
         }
       */
         try{
            t.sleep(30); //50ms delay
            canvas.repaint();
         }catch(Exception e){}
         
      }//end of for loop :>
   }//end of run method
}//end of thread