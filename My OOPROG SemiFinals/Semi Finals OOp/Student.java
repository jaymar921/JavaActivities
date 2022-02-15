/*
Create a class Student with the following attributes:
-	lastname : String
-	firstname: String
-	birthdate: Birthdate
-	yearlevel: int
-	gender: char
-	course: String
Create the appropriate constructors, setters and getters
Birthdate must be an inner class Of Student class
*/
public class Student{

	private String lastname;
	private String firstname;
	private Birthdate birthdate;
	private int yearLevel;
	private char gender;
	private String course;

	public Student(String lastname, String firstname, Birthdate birthdate, int yearLevel, char gender,String course){
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthdate = birthdate;
		this.yearLevel = yearLevel;
		this.gender = gender;
		this.course = course;
		}

	public Student(){}

	//setters
	public void setLastname(String lastname){
		this.lastname = lastname;
		}

	public void setFirstname(String firstname){
		this.firstname = firstname;
		}

	public void setBirthdate(Birthdate birthdate){
		this.birthdate = birthdate;
		}
	public void setYearLevel(int yearLevel){
		if(yearLevel >= 1 && yearLevel <= 4)
		 this.yearLevel  = yearLevel;
		}
	public void setGender(char gender){
		gender = Character.toUpperCase(gender);
		if(gender == 'M' || gender == 'F');
		 this.gender = gender;
		}

	public void setCourse(String course){
		this.course = course;
		}
	//getter
	public String getLastname(){
		return lastname;
		}

	public String getFirstname(){
		return firstname;
		}

	public Birthdate getBirthdate(){
		return birthdate;
		}

	public int getYearLevel(){
		return yearLevel;
		}

	public char getGender(){
		return gender;
		}

	public String getCourse(){
		return course;
		}

   //add more data to be returned
   public String toString(){
	   return lastname + "  " + firstname + " " +getBirthdate();
	   }
	public static void main(String [] args){
		Student student = new Student();
		student.setLastname("Capueras");
		student.setFirstname("Emelie");
		student.setBirthdate(new Birthdate(4,5,6));
		System.out.println("student is " + student);
		}
}