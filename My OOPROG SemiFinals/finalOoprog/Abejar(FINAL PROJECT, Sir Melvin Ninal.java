class ATM{
   
   public String name;       // name of the person will be stored
   private double balance;    // the current balance of the person will be stored in double
   public String accountNumber; //accountnumber will be called(need for login method and theGUI)
   private StringBuffer data;       // person data will be stored here before writing to a file (to avoid losing the data when a file is opened)
   private java.util.Random ran = new java.util.Random();   // I'm using this random class for random numbers for accountnumber
   private java.time.LocalDateTime todayDate;    //this will get the current time, store it for transaction tracking
   public boolean isLoggedOn = false; //check if the user was logged on or not;


   //what happens here is that this method will need name and amount to put in the bank for new account
   public boolean openAccount(String name, double amount){
      boolean success = false;
      this.name = new String();

      String dateOfOpen = todayDate.now().toString()+"";
      
      this.name = name;
      this.balance = amount;
      int numbers = ran.nextInt(500000);  // random numbers will be created, ranging from 0 to 500,000
      
      this.accountNumber = name.toUpperCase() + numbers;   //account number will be the NAME+RandomNumbers
      
      // name : Jay -> JAY294907
      
      //I'll use a csv ( comma separated values) for the file reader to handle the data when it is
      //splitted in to fragments
      //It will be easier to me to read the csv file
      try{
         java.io.FileWriter new_data = new java.io.FileWriter(accountNumber+".txt");
         System.out.println(todayDate.now().toString() + "," + "Transaction_Type:OPEN,"+amount);
         new_data.write(todayDate.now().toString() + "," + "Transaction_Type:OPEN,"+amount);
         new_data.close();
         success = true;
         javax.swing.JOptionPane.showMessageDialog(null,"Open Account Successful","OPEN ACCOUNT",javax.swing.JOptionPane.PLAIN_MESSAGE);
      }catch(Exception e){
      //if there will be an exception, success will be false causing the opening of account to be halted.
      javax.swing.JOptionPane.showMessageDialog(null,"Open Account Failed!","OPEN ACCOUNT",javax.swing.JOptionPane.ERROR_MESSAGE);
         success = false;
      }
      
      
      
      
      return success;
   }
   
   //Next method will be the login method, it will need the parameter of Account number + pin, default pin will be 1234(for demo purpose)
   public boolean login(String accountNumber, String pin){
      boolean authorized = false;
      this.accountNumber = accountNumber;
      this.name = new String();
      try{
         //check if the account data exist
         java.io.File file = new java.io.File(accountNumber+".txt.");

         
         //Now to get the name in the file --> JAY294907, I need to remove the numbers
         java.util.StringTokenizer getName = new java.util.StringTokenizer(accountNumber,"0123456789",true);
         this.name = getName.nextToken();
         this.name.toLowerCase();
         //Character.toString(this.name.charAt(0)).toUpperCase();
         
         //I will check if the file exist, if not found then the person/user must create/open a new account
         if(file.exists()){
            //System.out.println("It exist");
            //If the accountnumber exist, I want to save the file in the computer memory before the save account will replace the file
            java.util.Scanner read = new java.util.Scanner(file);
            data = new StringBuffer();
            //reading the lines inside the user data
            while(read.hasNextLine()){
               String getData = read.nextLine();
               if(getData.equals("")) break;
               String[] latestFragment = getData.split(",");
               data.append(getData).append("\n");
               this.balance = Double.parseDouble(latestFragment[2]); // <- get the current balance of the user if there a balance
               
            }
            
            if(pin.equals("1234")){
               authorized = true;
               isLoggedOn = true;
               javax.swing.JOptionPane.showMessageDialog(null,"Login Success","LOGIN",javax.swing.JOptionPane.PLAIN_MESSAGE);
               String transact = todayDate.now().toString()+","+"Transaction_Type:LOGIN,"+this.balance;
               data.append(transact).append("\n");
               try{
                  java.io.FileWriter data = new java.io.FileWriter(accountNumber+".txt");
                  data.write(this.data.toString());
                  data.close();
               }catch(Exception e){}
            }else{
            //if incorrect password but account is found, it will wipe out the data inside the memory and avoid the user to login
            this.data = new StringBuffer();
            this.balance = 0;
            this.name = new String();
               javax.swing.JOptionPane.showMessageDialog(null,"Login Failed : Incorrect Password","LOGIN",javax.swing.JOptionPane.ERROR_MESSAGE);
            }
         }else{
            //System.out.println("Please create an account");
            javax.swing.JOptionPane.showMessageDialog(null,"Login Failed : Account Not Found!","LOGIN",javax.swing.JOptionPane.ERROR_MESSAGE);
            authorized = false;
         }
      }catch(Exception e){
         
      }finally{
      }
      return authorized;
   }
   
   //this next method will check the balance of the user, only if the user was logged on
   public double balanceInquiry(){
      if(isLoggedOn){
         String transact = todayDate.now().toString()+","+"Transaction_Type:BAL_INQUIRY,"+this.balance;
         data.append(transact).append("\n");
         //save the transaction
         try{
         //basically this saves everything in the acount file, all the time, transactiontype and the current balance
            java.io.FileWriter data = new java.io.FileWriter(accountNumber+".txt");
            data.write(this.data.toString());
            data.close();
         }catch(Exception e){}
         
         
         return this.balance;
      }
      return 0;
      
   }
   
   public void deposit(double amount){
      if(isLoggedOn){
         this.balance+=amount;
         //add the current balance and save the transaction to account file
         String transact = todayDate.now().toString()+","+"Transaction_Type:DEPOSIT,"+this.balance;
         data.append(transact).append("\n");
         javax.swing.JOptionPane.showMessageDialog(null,"Deposit Success : P"+amount+" is added to your account","Deposit",javax.swing.JOptionPane.PLAIN_MESSAGE);
      }
      //save the transaction
      try{
      //basically this saves everything in the acount file, all the time, transactiontype and the current balance
         java.io.FileWriter data = new java.io.FileWriter(accountNumber+".txt");
         data.write(this.data.toString());
         data.close();
      }catch(Exception e){}
   }
   
   public boolean withdraw(double amount){
      boolean ok = false;
      if(isLoggedOn){
         if(this.balance < amount){
            javax.swing.JOptionPane.showMessageDialog(null,"Withdrawal Failed : Insufficient Balance!","Withdrawal",javax.swing.JOptionPane.ERROR_MESSAGE);
         }else{
         //deduct  the current balance and save the transaction to account file
            this.balance -= amount;
            String transact = todayDate.now().toString()+","+"Transaction_Type:WITHDRAWAL,"+this.balance;
            data.append(transact).append("\n");
            javax.swing.JOptionPane.showMessageDialog(null,"Withdrawal Success : P"+amount+" is deducted to your account","Withdrawal",javax.swing.JOptionPane.PLAIN_MESSAGE);
            ok = true;
         }
         
      }
      
      //save the transaction
      try{
      //basically this saves everything in the acount file, all the time, transactiontype and the current balance
         java.io.FileWriter data = new java.io.FileWriter(accountNumber+".txt");
         data.write(this.data.toString());
         data.close();

      }catch(Exception e){}
      
      return ok;
   }
   
   public void closeAccount(String accNumber, boolean logoutOrClose){
      String transact;
      try{
         if(logoutOrClose)
            transact = todayDate.now().toString()+","+"Transaction_Type:CLOSE,"+this.balance;
         else
            transact = todayDate.now().toString()+","+"Transaction_Type:LOGOUT,"+this.balance;
         data.append(transact).append("\n");
         java.io.FileWriter data = new java.io.FileWriter(accountNumber+".txt");
         data.write(this.data.toString());
         data.close();
      }catch(Exception e){}
   }
}//end of atm class
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////       /////////////  ///////  ///////////        ///////////////////////////////////////////////////////////////
//////////////////  ////////////////////  ///////  //////////////  //////////////////////////////////////////////////////////////////
/////////////////  /////////////////////  ///////  //////////////  //////////////////////////////////////////////////////////////////
/////////////////  /////////////////////  ///////  //////////////  //////////////////////////////////////////////////////////////////
/////////////////  /////    ////////////  ///////  //////////////  //////////////////////////////////////////////////////////////////
/////////////////  ///////  ////////////  ///////  //////////////  //////////////////////////////////////////////////////////////////
/////////////////  ///////  ////////////  ///////  //////////////  //////////////////////////////////////////////////////////////////
///////////////////       //////////////           ///////////        ///////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class ATMGUI extends javax.swing.JFrame implements java.awt.event.ActionListener{


   javax.swing.JPanel menuPanel,registerPanel,loginPanel, loggedInPanel, statusPanel;
   javax.swing.JButton loginAccount, openAccount,login,cancel,deposit,bal,withdraw,close,exit,register;
   java.awt.Font font1 = new java.awt.Font("Algerian", java.awt.Font.BOLD, 25);
   java.awt.Font font2 = new java.awt.Font("Algerian", java.awt.Font.PLAIN, 15);
   javax.swing.JLabel menuTitle,username,pin,accountName,acname,accountNumber,acnum, status_1,status_2, register_amount;
   javax.swing.JTextField user_input, pin_input, input_get, enter_name, enter_value;
   double current_bal = 0;
   private boolean loginWindow = false, loggedInWindow = false, registerWindow = false;
   private ATM data;
   
   public ATMGUI(){
      setTitle("Jayharron Automatic Teller Machine");
      setSize(500,400);
      setLocationRelativeTo(null);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      data = new ATM();
      
      // MENU COMPONENTS
      loginAccount = new javax.swing.JButton("LOGIN ACCOUNT");
      loginAccount.setFont(font2);
      openAccount = new javax.swing.JButton("OPEN ACCOUNT");
      openAccount.setFont(font2);
      
      loginAccount.addActionListener(this);
      openAccount.addActionListener(this);

      
      menuTitle = new javax.swing.JLabel("Automatic Teller Machine", javax.swing.JLabel.CENTER);
      menuTitle.setFont(font1);
      
      menuPanel = new javax.swing.JPanel(new java.awt.GridLayout(2,1,10,10));
      
      // LOGIN COMPONENTS
      loginPanel = new javax.swing.JPanel(new java.awt.GridLayout(3,2));
      
      username = new javax.swing.JLabel("Enter Account Number:");
      pin = new javax.swing.JLabel("Enter Account Pin:");
      
      username.setFont(font2);
      pin.setFont(font2);
      
      user_input = new javax.swing.JTextField();
      pin_input = new javax.swing.JTextField();
      
      login = new javax.swing.JButton("Login");
      cancel = new javax.swing.JButton("Cancel");
      
      login.addActionListener(this);
      cancel.addActionListener(this);
      
      // LOGGED IN WINDOW COMPONENTS
      loggedInPanel = new javax.swing.JPanel(new java.awt.GridLayout(4,2,10,10));
      
      accountName = new javax.swing.JLabel("-");
      accountName.setFont(font2);
      
      accountNumber = new javax.swing.JLabel("-");
      accountNumber.setFont(font2);
      
      acname = new javax.swing.JLabel("Account Name: ");
      acname.setFont(font2);
      
      acnum = new javax.swing.JLabel("Account Number: ");
      acnum.setFont(font2);
      
      deposit = new javax.swing.JButton("DEPOSIT");
      deposit.setFont(font2);
      deposit.addActionListener(this);
      bal = new javax.swing.JButton("BALANCE INQUIRE");
      bal.setFont(font2);
      bal.addActionListener(this);
      withdraw = new javax.swing.JButton("WITHDRAW");
      withdraw.setFont(font2);
      withdraw.addActionListener(this);
      close = new javax.swing.JButton("CLOSE ACCOUNT");
      close.setFont(font2);
      close.addActionListener(this);
      // REGISTER COMPONENTS
      registerPanel = new javax.swing.JPanel(new java.awt.GridLayout(3,2,10,10));
      
      enter_name = new javax.swing.JTextField();
      enter_name.setFont(font2);
      enter_value = new javax.swing.JTextField();
      enter_value.setFont(font2);
      
      register_amount = new javax.swing.JLabel("Enter amount: ");
      register_amount.setFont(font2);
      
      register = new javax.swing.JButton("OPEN ACCOUNT");
      register.setFont(font2);
      register.addActionListener(this);
            
      
      //STATUS COMPONENTS
      
      statusPanel = new javax.swing.JPanel(new java.awt.GridLayout(2,2,10,10));
      
      status_1 = new javax.swing.JLabel("STATUS: ");
      status_1.setFont(font2);
      status_2 = new javax.swing.JLabel("ONLINE");
      status_2.setFont(font2);
      
      exit = new javax.swing.JButton("LOGOUT");
      exit.setFont(font2);
      exit.addActionListener(this);
      
      statusPanel.add(status_1);
      statusPanel.add(status_2);
      statusPanel.add(new javax.swing.JLabel(" "));
      statusPanel.add(exit);

      menu();
      
      setLayout(new java.awt.BorderLayout());
      add(menuTitle, java.awt.BorderLayout.NORTH);
      add(menuPanel,java.awt.BorderLayout.SOUTH);
      
      setVisible(true);
   }
   
   //ACTION LISTENER
   public void actionPerformed(java.awt.event.ActionEvent e){
      if(e.getSource() == loginAccount){
         login();
      }
      if(e.getSource() == cancel){
         menu();
      }
      if(e.getSource() == login){
         String userName = user_input.getText();
         String pinInput = pin_input.getText(); 
         
         if(data.login(userName,pinInput)){
            pin_input.setText("");
            user_input.setText("");
            status_1.setText("STATUS: ");
            status_2.setText("ONLINE");
            loggedIn();
         }else{
            pin_input.setText("");
         }
      }
      if(e.getSource() == bal){
         current_bal = data.balanceInquiry();
         status_1.setText("STATUS: BALANCE INQUIRY");
         status_2.setText("P"+current_bal+"");
      }
      if(e.getSource() == close){
         int option = javax.swing.JOptionPane.showConfirmDialog(null,"You are about to close your account\nAre you sure?"); 
         if(option == javax.swing.JOptionPane.YES_OPTION){
            status_1.setText("STATUS: ");
            status_2.setText("OFFLINE");
            accountName.setText("User Logged out");
            accountNumber.setText("Account Logged out");
            javax.swing.JOptionPane.showMessageDialog(null,"Successfully Closed Account");
            data.closeAccount(accountNumber.getText(),true);
            data = new ATM();
            menu();
         }
      }if(e.getSource() == exit){
         status_1.setText("STATUS: ");
         status_2.setText("OFFLINE");
         accountName.setText("User Logged out");
         accountNumber.setText("Account Logged out");
         data.closeAccount(accountNumber.getText(),false);
         javax.swing.JOptionPane.showMessageDialog(null,"Logged out successfuly");
         data = new ATM();
         menu();
      }
      if(e.getSource() == deposit){
         status_1.setText("STATUS: DEPOSIT AMOUNT");
         status_2.setText("P ");
         String amt=javax.swing.JOptionPane.showInputDialog(null,"How much you will deposit?");
         try{
            double amount_entered = Double.parseDouble(amt);
            status_2.setText("P "+amount_entered+ " Added to account");
            data.deposit(amount_entered);
         }catch(Exception err){
            status_1.setText("STATUS: ");
            status_2.setText("ONLINE");
            javax.swing.JOptionPane.showMessageDialog(null,"Please input a valid value");
         }
      }
      if(e.getSource() == withdraw){
         status_1.setText("STATUS: WITHDRAWAL");
         status_2.setText(": CURRENT BALANCE P"+data.balanceInquiry());
         String amt=javax.swing.JOptionPane.showInputDialog(null,"How much you will withdraw?");
         try{
            double amount_entered = Double.parseDouble(amt);
            if(data.withdraw(amount_entered)){
               status_2.setText("P "+amount_entered+ " Deducted");
             }else{
               status_2.setText("Withdrawal Failed");
             }
         }catch(Exception err){
            status_1.setText("STATUS: ");
            status_2.setText("ONLINE");
            javax.swing.JOptionPane.showMessageDialog(null,"Please input a valid value");
         }
      }
      if(e.getSource() == openAccount){
         register();
      }if(e.getSource() == register){
         String name = enter_name.getText();
         String amount = enter_value.getText();
         double amt_ = 0;
         try{
            amt_ = Double.parseDouble(amount);
            data.openAccount(name, amt_);
            loggedIn();
            bal.setEnabled(false);
            deposit.setEnabled(false);
            withdraw.setEnabled(false);
            close.setEnabled(false);
            javax.swing.JOptionPane.showMessageDialog(null,"Account Number: "+accountNumber.getText()+"\nYour account was created but you have to\nlogout first for your account to be activated\nYour default pin is : 1234");
         }catch(Exception errre){
            enter_value.setText("");
            javax.swing.JOptionPane.showMessageDialog(null,"Please input a valid value");
         }
         
      }

   }
   //this changes the gui components to MENU type instead of opening new frame
   public void menu(){
      if(loginWindow){
         menuPanel.remove(loginPanel);
         loginWindow = false;
      }if(loggedInWindow){
         menuPanel.remove(loggedInPanel);
         menuPanel.remove(statusPanel);
         loggedInWindow = false;
      }if(registerWindow){
         registerWindow = false;
         menuPanel.remove(registerPanel);
      }
      
      
      
      menuPanel.add(loginAccount);
      menuPanel.add(openAccount);
      
      
      
      menuPanel.revalidate();  
      remove(menuPanel);
      add(menuPanel,java.awt.BorderLayout.SOUTH);
      validate();  
      repaint(); 

      

   }
   
   //instead of opening new window/frame, the gui panel will swap to register form
   public void register(){
      registerWindow = true;
      menuPanel.remove(openAccount);
      menuPanel.remove(loginAccount);
      
      registerPanel.add(acname);
      registerPanel.add(enter_name);
      registerPanel.add(register_amount);
      registerPanel.add(enter_value);
      registerPanel.add(register);
      registerPanel.add(cancel);
      
      menuPanel.add(registerPanel);
      
      menuPanel.revalidate();  
      remove(menuPanel);
      add(menuPanel,java.awt.BorderLayout.CENTER);
      validate();  
      repaint(); 
      
   }
   //login form gui panel
   public void login(){
      loginWindow = true;
      menuPanel.remove(openAccount);
      menuPanel.remove(loginAccount);
      
      bal.setEnabled(true);
      deposit.setEnabled(true);
      withdraw.setEnabled(true);
      close.setEnabled(true);
      
      loginPanel.add(username);
      loginPanel.add(user_input);
      loginPanel.add(pin);
      loginPanel.add(pin_input);
      loginPanel.add(login);
      loginPanel.add(cancel);
      
      menuPanel.add(loginPanel);
      
      menuPanel.revalidate();  
      remove(menuPanel);
      add(menuPanel,java.awt.BorderLayout.CENTER);
      validate();  
      repaint(); 
   }
   
   //logged in panel
   public void loggedIn(){
      loggedInWindow = true;
      if(loginWindow){
         menuPanel.remove(loginPanel);
         loginWindow = false;
      }
      if(registerWindow){
         registerWindow = false;
         menuPanel.remove(registerPanel);
      }
      String name = data.name;
      String accNum = data.accountNumber;
      
      accountName.setText(name);
      accountNumber.setText(accNum);
      
      loggedInPanel.add(acnum);
      loggedInPanel.add(accountNumber);
      loggedInPanel.add(acname);
      loggedInPanel.add(accountName);
      loggedInPanel.add(bal);
      loggedInPanel.add(deposit);
      loggedInPanel.add(withdraw);
      loggedInPanel.add(close);
      
      menuPanel.add(loggedInPanel);
      menuPanel.add(statusPanel);
      
      menuPanel.revalidate();  
      remove(menuPanel);
      add(menuPanel,java.awt.BorderLayout.CENTER);
      validate();  
      repaint(); 
   }

   
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////     ////////////          //////////  //////////  ////////           //////////////////////////////////////
///////  ////   /////////  //////////////////    //////    ////////  ///////  //////////////////////////////////////
///////  ///////  ///////  //////////////////  /  ///  //  ////////  ///////  //////////////////////////////////////
///////  ///////  ///////          //////////  ///  /////  ////////  ///////  //////////////////////////////////////
///////  ///////  ///////  //////////////////  //////////  ////////  ///////  //////////////////////////////////////
///////  ///////  ///////  //////////////////  //////////  ////////  ///////  //////////////////////////////////////
///////  /////   ////////  //////////////////  //////////  ////////  ///////  //////////////////////////////////////
///////       ///////////         ///////////  //////////  ////////           //////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// MAIN
public class Abejar{//demo class
   public static void main(String[] args){
      new ATMGUI();
      //ATM b = new ATM();
      //b.openAccount("Jay",200);
      //b.login("JAY36079","1234");
      //b.login("JAY137580","1234");
      //System.out.println(b.balanceInquiry());
      //b.deposit(100);
      //System.out.println(b.balanceInquiry());
      //b.withdraw(240);
      //System.out.println(b.balanceInquiry());
      //a.closeAccount();
   }
}//end of the demo class
