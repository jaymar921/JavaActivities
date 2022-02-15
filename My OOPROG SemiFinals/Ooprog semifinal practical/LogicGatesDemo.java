/**
   Abejar, Jayharron Mar
   Object Oriented Programming
**/
class LogicGates{
   
   //buffer
   public boolean BUFFER(boolean A){
      return A;
   }
   
   //and
   public boolean AND(boolean A, boolean B){
      return A && B;
   }
   
   //inverter
   public boolean INVERTER(boolean A){
      return !A;
   }
   
   //nand
   public boolean NAND(boolean A, boolean B){
      return !(!(A) && !(B));
   }
   //OR
   public boolean OR(boolean A, boolean B){
      if(A || B)
         return true;
      else
         return false;
   }
   //NOR
   public boolean NOR(boolean A, boolean B){
      if(!(A || B))
         return true;
      else
         return false;
   }
   //XOR
   public boolean XOR(boolean A, boolean B){
   boolean ok = false;
      if(A== true && B ==false)
         ok = true;
      else if(A==false && B == true)
         ok = true;
      return ok;
   }
   //XNOR
   public boolean XNOR(boolean A, boolean B){
      if(!(A || B) || (A && B))
         return true;
      else
         return false;
   }
}//end of logic gate claSs


class LogicGatesGUI extends javax.swing.JFrame implements java.awt.event.ItemListener {
   
   //here are my attributes
   LogicGates lg = new LogicGates();
   javax.swing.JTextField inA, inB, result;
   javax.swing.JComboBox options = new javax.swing.JComboBox();
   javax.swing.JLabel lblA, lblB;
   
   LogicGatesGUI(){
      super("Logic Gates by Jayharron"); // <- name of my window/frame
      setVisible(true); // visible for user
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new java.awt.GridLayout(3,2)); // divide th e frame by 3 rows, 2 cols
      
      //initialization of my reference variables
      inA = new javax.swing.JTextField(1);   
      inB = new javax.swing.JTextField(1);
      result = new javax.swing.JTextField();
      result.setEditable(false);
      options.addItem("BUFFER");
      options.addItem("INVERTER");
      options.addItem("AND");
      options.addItem("NAND");
      options.addItem("OR");
      options.addItem("NOR");
      options.addItem("XOR");
      options.addItem("NXOR");
      
      lblA = new javax.swing.JLabel("Enter A: ");
      lblB = new javax.swing.JLabel("Enter B: ");
      
      //adding the objects into the gridlayout
      add(lblA);
      add(inA);
      add(lblB);
      add(inB);
      add(options);
      add(result);
      
      //adding options combobox a itemListener
      options.addItemListener(this);
      //
      setSize(300,200); // < set the size of my frame by 300px wide and 200px height
   }
   
   //this part will drive the event happened in the combobox
   public void itemStateChanged(java.awt.event.ItemEvent event){
      
      
      
      try{
      int A = Integer.parseInt(inA.getText());
      int B = Integer.parseInt(inB.getText());
      if((A>1 || A < 0) || (B>1 || B<0))
         javax.swing.JOptionPane.showMessageDialog(null,"Any value aside from 1 is false");//i put a promt message if ang user ni enter ug value asside from 0 1
      boolean bolA = false;
      boolean bolB = false;
      if(A==1)
         bolA = true;
      else
         bolA = false;
      if(B==1)
         bolB = true;
      else 
         bolB = false;
         
         //the event will go through this if statements
         //get the buffer
      if(options.getSelectedIndex() == 0){
         result.setText(lg.BUFFER(bolA) + " result of A");
      }
      //get the inverter
      if(options.getSelectedIndex() == 1){
         result.setText(lg.INVERTER(bolA) + " result of A");
      }
      //get the and
      
      if(options.getSelectedIndex() == 2){
         result.setText(lg.AND(bolA, bolB) + " result of A & B");
      }
      //get the nand
      if(options.getSelectedIndex() == 3){
         result.setText(lg.NAND(bolA, bolB) + " result of A & B");
      }
      //get the or
      if(options.getSelectedIndex() == 4){
         result.setText(lg.OR(bolA, bolB) + " result of A & B");
      }
      //get the nor
      if(options.getSelectedIndex() == 5){
         result.setText(lg.NOR(bolA, bolB) + " result of A & B");
      }
      //get the xor
      if(options.getSelectedIndex() == 6){
         result.setText(lg.XOR(bolA, bolB) + " result of A & B");
      }
      //get the xnor
      if(options.getSelectedIndex() == 7){
         result.setText(lg.XNOR(bolA, bolB) + " result of A & B");
      }
      }catch(Exception e){
         javax.swing.JOptionPane.showMessageDialog(null,"Please enter a value of 1 or 0 on A and B");
         inA.setText("");
         inB.setText("");
         result.setText("");
      }
   }//end of item listener
      
   
}//end of GUI class

//logic gate demo class
public class LogicGatesDemo{
   
   public static void main(String[] args){
      javax.swing.JOptionPane.showMessageDialog(null,"Any value aside from 1 is false\nMake sure to fill in both A and B textfields");
      new LogicGatesGUI();
   }
}//end of logic gate demo class