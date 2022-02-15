

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Scanner;
import java.util.StringTokenizer;

class ATM {     
    String name;
    public double balance;
    public double result;
    String accnum;
    LocalDate date;

  public void openAccount(String name, int amount){
     
     balance = amount;
     accnum= name;
     this.name = name;
     date = LocalDate.now();
     
     try{   
                 
        FileWriter file = new FileWriter(accnum+".txt");
  
           file.write(date + ",transactionType:OPEN," + balance);            
           file.close();
  
     }catch(Exception e){
        System.out.println("There's an error creating the account...");
        }    
  }
  
  public void login(String username, int pin ){
     
     try{
         File fr=new File(username+".txt");
         Scanner s = new Scanner(fr);  
         if(!fr.exists()){
            return;
            }
         while(s.hasNextLine()){
            String temp_data = s.nextLine();
            StringTokenizer str = new StringTokenizer(temp_data,",",false);
            
            String tmp1 = str.nextToken();
            
            String tmp2 = str.nextToken();
            
            balance = Integer.parseInt(str.nextToken());
           
         }
     }catch(Exception ee){
        System.out.println("Account is not found...");
      

     }   
  }
  
  public void balanceInquiry(double balance){
      balance = balance;
  }
  
  public void deposit(double depositAmount){
      balance +=depositAmount;
      JOptionPane.showMessageDialog(null,"P"+depositAmount+" has been added to your account");
  }
  
  public void withdraw(double withdrawAmount){
      balance -=withdrawAmount;
  }
  
  public void closeAccount(double balance, String accnum){
      balance = 0; accnum= "";
  }

}

class ATMGUI extends JFrame implements ActionListener{
	
//what I will put in the data String is the 0 - name, 1 - balance
 String[] data = new String[2];
 JPanel p1;
 JButton btn1, btn2;
 JLabel la1,la2;
 JTextField t1, t2;
 
  public ATMGUI(){
	   
     super("ATM Machine by Ministerio");
     
     p1 = new JPanel();
    
     setLayout(new GridLayout(2,2));

     la1= new JLabel("ATM by Ministerio", JLabel.CENTER);   
     la1.setFont(new Font("TimesRoman", Font.BOLD, 18)); 
     la1.setBounds(10,10,20,20);
     
     
     btn1= new JButton("Open Account");
     btn1.setBounds(50,20,20,15);
     btn1.setFocusable(false);
     btn2 = new JButton("Login");
     btn2.setBounds(60,20,20,15);
     btn2.setFocusable(false);
     
     p1.add(btn1);        p1.add(btn2);
     btn1.addActionListener(this);
     btn2.addActionListener(this);
     
     add(la1); 
     add(p1);
     setSize(400, 150);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setVisible(true);
     setResizable(false); 
   }  
   
  public void actionPerformed(ActionEvent e){  
     
      if(e.getSource()==btn1)	 new openaccGUI();   
      
      else if(e.getSource()==btn2)       new loginGUI();
      
      this.hide();
   }
   
  }
class openaccGUI extends JFrame implements ActionListener{
	  JFrame f = new JFrame();
	  
     JLabel l1,l2,l3;
     JPanel panel1;
     JTextField tf1,tf2,tf3;
     JButton b1, b2;
     
     public openaccGUI(){  
       
        setTitle("Open Account");
        
        l1= new JLabel("Account ID: ");
        tf1= new JTextField(10);
        
        l2 = new JLabel("Balance: ");
        tf2= new JTextField(10);
        
        l3= new JLabel("Password: ");
        tf3 = new JTextField(10);
  
        b1 = new JButton("Create Account");
        b1.setFocusable(false);
        
        b2= new JButton("Back");
        b2.setFocusable(false);
       
        b1.addActionListener(this);
        b2.addActionListener(this);

        add(l1);    add(tf1);
        add(l2);    add(tf2);
        add(l3);    add(tf3);
        add(b1);    add(b2);
        
        setLayout(new GridLayout(5,2));
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        }
        
     public void actionPerformed(ActionEvent e){  
   	  
     
   	  String name = tf1.getText();
   	  String balance = tf2.getText();
   	  String pass = tf3.getText();
   	  
   	  if(e.getSource()==b1) {
   		  JOptionPane.showMessageDialog(f," Succesfully added.");
           ATM a = new ATM();
           a.openAccount(name,Integer.parseInt(balance));
   	  }else if(e.getSource()==b2) {
   		  new ATMGUI();
   		  this.hide();
   	  }  
   }        
 } 
 
 class loginGUI extends JFrame implements ActionListener{
 
  JLabel acname, pass;
  JTextField text1, text2;
  JButton l,back;
    
     public loginGUI(){
       
        setTitle("Log in Account");
        
        acname= new JLabel("Account Name: ");
        text1= new JTextField(10);
        
        pass = new JLabel("Password: ");
        text2= new JTextField(10);
        text2.setText("1234");
        text2.setEditable(false);
  
        l = new JButton("Log in");
        l.setFocusable(false);
        
        back = new JButton("Back");
        back.setFocusable(false);
        
        l.addActionListener(this);
        back.addActionListener(this);

        add(acname);    add(text1);
        add(pass);    add(text2);
        add(l);        add(back);
        setLayout(new GridLayout(3,2));
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
       
     }
     public void actionPerformed(ActionEvent e){  
      
      if(e.getSource()==l)          new anotherLogInGUI(text1.getText());
             
      else if(e.getSource()==back)                
   	    new ATMGUI();
            		this.hide();
   }
 }
 
 class anotherLogInGUI extends JFrame implements ActionListener{
     
     JLabel title;
     JButton balanceinquiry, deposit, withdraw, closeAcc, anotherLogIn_back;
     String user;
     public anotherLogInGUI(String name){
        user = name;
        setTitle("Welcome!");
        title= new JLabel("Choose One Transaction You Want", JLabel.CENTER);
         
        balanceinquiry = new JButton("Balance Inquiry");
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        closeAcc = new JButton("Close Account");
        
        balanceinquiry.addActionListener(this);
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        closeAcc.addActionListener(this);
        
        anotherLogIn_back = new JButton("Back");
        anotherLogIn_back.addActionListener(this);
        
        add(title);   add(balanceinquiry);   add(deposit);    add(withdraw);   add(closeAcc);    add(anotherLogIn_back);
        
        setLayout(new GridLayout(6,1));
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
     }
     public void actionPerformed(ActionEvent e){  
     
         if(e.getSource()==balanceinquiry)                new balanceinquiryGUI(user);
         else if(e.getSource()==deposit)                  new depositGUI(user);
         else if(e.getSource()==withdraw)                 new withdrawGUI();
         else if(e.getSource()== closeAcc)                new  closeAccountGUI();
         else if(e.getSource()== anotherLogIn_back)       new loginGUI();
         this.hide();
   }
 
 }

 class balanceinquiryGUI extends JFrame implements ActionListener{
     
     JLabel balances;
     JButton balance_back;
     JTextField jtextf;
     ATM g;
     
     public balanceinquiryGUI(String name){
        
        
        super("Balance Inquiry");
        balances= new JLabel("Balance");
        
        JTextField tf2 = new JTextField();
        System.out.println(name);
        g = new ATM();
        g.login(name,1234);
        
        jtextf = new JTextField();
        String t = tf2.getText();
        jtextf.setText(g.balance + "");
        
        jtextf.setEditable(false); 
         
        balance_back = new JButton("Back");
        balance_back.addActionListener(this);
        
        add(balances);   add(jtextf);   add(balance_back);
        
        setLayout(new GridLayout(4,2));
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

     }
     public void actionPerformed(ActionEvent e){  
                         
      if(e.getSource()== balance_back)                new loginGUI();
      
      this.hide();
   }
 }

class depositGUI extends JFrame implements ActionListener{
     
     JLabel deposit;
     JButton deposit_amount, deposit_back;
     JTextField d_tf1, d_tf2;
     ATM a;
     String userName;

     public depositGUI(String name){
        
        super("Deposit");
        deposit= new JLabel("Enter Amount:");
        a = new ATM();
        userName = name;
        
        JTextField tf2 = new JTextField();
        d_tf1 = new JTextField(10);
        d_tf2 = new JTextField(10);
        d_tf2.setEditable(false);
        
        deposit_amount= new JButton("Deposit");
        deposit_amount.addActionListener(this);
        deposit_back = new JButton("Back");
        deposit_back.addActionListener(this);
        
        add(deposit);      
        add(d_tf1);        add(d_tf2);
        add(deposit_amount);
        add(deposit_back);
        
        setLayout(new GridLayout(5,2));
        setSize(450, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

     }
  public void actionPerformed(ActionEvent e){  
      if(e.getSource()== deposit_amount){
         // new Deposit().setVisible(true);
         a.login(userName,1234);
         a.deposit(Double.parseDouble(d_tf1.getText()));
         this.hide();
         new loginGUI();
      
       }else if(e.getSource()== deposit_back){                new loginGUI();
        this.hide();
       }
   }
 }
class withdrawGUI extends JFrame implements ActionListener{
     
     JLabel withdraw;
     JButton withdraw_back;
     
     public withdrawGUI(){
        
        super("Withdraw");
        withdraw= new JLabel("Enter Amount: ");
         
        withdraw_back = new JButton("Back");
        withdraw_back.addActionListener(this);
        
        add(withdraw);   add(withdraw_back);
        
        setLayout(new GridLayout(3,2));
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

     }
     
    public void actionPerformed(ActionEvent e){  
     
      if(e.getSource()== withdraw_back)                new loginGUI();
      this.hide();
   }
 
 }
  class closeAccountGUI extends JFrame implements ActionListener{
       
     JLabel closeAccount;
     JButton closeAccount_back,caccount;
     
     public closeAccountGUI(){
        
        super("Close Account");
        closeAccount= new JLabel("Close Account");
         
        caccount = new JButton("Close Account");
        caccount.addActionListener(this);

        closeAccount_back = new JButton("Back");
        closeAccount_back.addActionListener(this);
        
        add(caccount);    add(closeAccount_back);
        setLayout(new GridLayout(3,2));
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);    
     }
     
      public void actionPerformed(ActionEvent e){  
     
         if(e.getSource()== caccount)                              new ATMGUI();
         
         else if(e.getSource()== closeAccount_back)                new loginGUI();
            
         this.hide();
       }

   }
   
public class ministerio{

public static void main(String[] args){

  new ATMGUI();
     
  }
}
