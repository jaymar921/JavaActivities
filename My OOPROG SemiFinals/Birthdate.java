/**
   BIRTHDATE CLASS
   BY: ABEJAR, JAYHARRON MAR C.
   
   CLASS CONTAINS
   attributes
   -int day
   -int month
   -int year
   
   sets
   -day, month, year
   gets
   -day, month, year, age
   toString()
   -year/month/day;age
**/
//I imported some important packages for gtting the age of the person
import java.time.LocalDate;
import java.util.StringTokenizer;
public class Birthdate{
   //class attributes
   private int day, month, year;
   
   //constructors
   public Birthdate(int day, int month, int year){
      this.day = day;
      this.month = month;
      this.year = year;
   }
   //default constructor
   public Birthdate(){}
   
   //setters
   public void setDay(int day)      {  this.day = day;}
   public void setMonth(int month)  {  this.month = month;}
   public void setYear(int year)    {  this.year = year;}
   //getters
   public int getDay()              {  return this.day;}
   public int getMonth()            {  return this.month;}
   public int getYear()             {  return this.year;}
   
   //get age, mam this is from me, my own understanding (I have no one to cheat, but ofcourse I need the internet for ref.)
   public int getAge(){
      LocalDate d = LocalDate.now(); // this grabs the date to day in YYYY/MM/DD
      String date = d.toString(); //I convert the date into to String for the String tokenizer
      StringTokenizer st = new StringTokenizer(date, "-"); //I learned this StringTokenizer from my dataStruct subject :)
      /**
         Since the Localdate gives the output at YYYY-MM-DD
         I use String tokenizer and split them into YYYY MM DD
         then I set year to YYYY, month to MM and date to DD
      **/
      int year_now = Integer.parseInt(st.nextToken()); //I convert String to int
      int month_now = Integer.parseInt(st.nextToken());
      int day_now = Integer.parseInt(st.nextToken());
      /**
         I determine to get the year by deducting the actual year now and the person's birth year
         then set it to age, after that I need to determine the month, if the month today is greater
         than a person's birthmonth, his age will be deducted by 1, else if month today is less than
         or equal to the month today, I need to determine the day. If the day today is greater than
         the day of the person's birthday, his age will be deducted by 1;
         
            It's sounds confusing mam.. di ko kabalo mo explain pero mao na ako naa sa utok :)
      **/
      int age = 0; //I declare the age as 0 for now
      if(this.year <= year_now){
         age = year_now - year;
         if(this.month == month_now){
            if(this.day>day_now)
               age-=1;
         }else if(this.month > month_now)
            age -= 1;
      }
      return age; //this is the age to be returned when needed :>
   }
   
   //override the toString method
   public String toString(){
      return "Birthdate: " + year + "/" + month + "/" + day + ", Age: " + getAge();
   }
   
   
}//end of class