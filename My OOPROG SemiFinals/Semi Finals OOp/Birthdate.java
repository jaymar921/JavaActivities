public class Birthdate{
		private int month;
		private int day;
		private int year;

		public Birthdate(int month, int day, int year){
			this.month = month;
			this.day = day;
			this.year = year;
			}

		public Birthdate(){}

		//setters
		public void setMonth(int month){
			this.month = month;
			}

		public void setDay(int day){
			this.day = day;
			}
		public void setYear(int year){
			this.year = year;
			}

		//getters
		public int getMonth(){
			return month;
			}

		public int getYear(){
			return year;
			}

		public int getDay(){
			return day;
			}
         
         //toString
         public String toString(){
            return getMonth() + " " + getDay() + ", " + getYear();
         }


		}