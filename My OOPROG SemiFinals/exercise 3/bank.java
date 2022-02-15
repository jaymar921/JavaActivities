/**
   Abejar Jayharron Mar Canillo
   BSIT - 2
   Object Oriented Programming Exercise 3
**/
import java.text.DecimalFormat;
public class bank{

   public static void main(String[] args){
      DecimalFormat fmt = new DecimalFormat("#.##");
      int balance, accountNumber, minimumBal;
      double newBalance = 0;
      char accountType;
      
      System.out.println("Welcome to the bank");
      System.out.print("Enter your account number: ");
      accountNumber = new java.util.Scanner(System.in).nextInt();
      System.out.println("[ S - SAVINGS | C - CHECKING ]");
      
      do{
         System.out.print("Enter your account type: ");
         accountType = new java.util.Scanner(System.in).next().charAt(0);
         accountType = Character.toLowerCase(accountType);
      }while(accountType!='s' && accountType!='c');
      System.out.print("Enter your current balance: $");
      balance = new java.util.Scanner(System.in).nextInt();
      System.out.print("Enter your minimum balance to maintain: $");
      minimumBal = new java.util.Scanner(System.in).nextInt();
      
      
      //if current bal < min
      // service charge of $10 for savings
      // service charge of $25 for checking
      if(balance < minimumBal){
         if(accountType == 's')
            newBalance = balance - 10;
         if(accountType == 'c')
            newBalance = balance - 25;
      }else{
         newBalance = balance;
      }
      
      //display outputs
      System.out.println("\n\nHello "+accountNumber);
      if(accountType=='s')
         System.out.println("Account Type: Savings Account");
      else
         System.out.println("Account Type: Checking Account");
       System.out.println("Current Balance: $"+fmt.format(balance));
       if(balance < minimumBal)
         System.out.println("Due to your account reached below the minimum\nbalance, you have been charged an service fee");
       System.out.println("New Balance: $"+fmt.format(newBalance));
       
       //if balance is minimum than the required 
       // for account type savings, they will receive 4% interest from the bank at the end of the month
       if(balance < minimumBal){
         if(accountType == 's'){
            System.out.println("If you maintain your balance at below the\nminimum balance required, you will receive an interest of 4%"+
            "\nat the end of the month");
            System.out.println("New Balance: $"+fmt.format(newBalance = (newBalance-(newBalance*0.04))));
         }
       }
       
       //for account type checking, if their balance falls up to $5000 or their balance is greater
       //than the minimum balance, they will receive 3% interest from the bank at the end of the month
       //otherwise they will get 5%
       if(accountType=='c'){
         if(balance < 5000 || balance > minimumBal){
            System.out.println("Since your account is for checking account\n by the end of the month, you will receive a 3% interest from the bank");
            System.out.println("New Balance: $"+fmt.format(newBalance = (newBalance-(newBalance*0.03))));
         }else{
            System.out.println("Since your account is for checking account\n by the end of the month, you will receive a 5% interest from the bank");
            System.out.println("New Balance: $"+fmt.format(newBalance = (newBalance-(newBalance*0.05))));

         }
       }
      
      
   }//end of main
}//end of bank class