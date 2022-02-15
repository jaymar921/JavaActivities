public class StudentList implements List{

	Student [] list;
	int count;

  //count represent idnumber of student

	public StudentList(int size){
		list = new Student[size];
		count = 0;
		}

	public StudentList(){
		 this(10);
		}

	public boolean isFull(){
		return count == list.length;
		}

	public boolean isEmpty(){
		 return count == 0;
		}

	//create e method here to double the size of the array
	public void doubleTheArray(){}

	public void add(Object obj){
		//if(isFull())
		 //call doubleTheArray
		if(obj instanceof Student){
			Student student  = (Student)obj;
			list[count++] = student;
			}

		}

	public void remove(int idno){

		}

	public boolean isFound(int idno){
       return false;
		}

	public void display(){
		for(int i = 0; i < count; i++){
		 System.out.println(list[i]);
	    }
		}

    public int getCount(){
		return count;
		}
	public static void main(String [] args){
		StudentList list = new StudentList();
		Student student = new Student();
		student.setLastname("Abejar");
		student.setFirstname("Jayharron Mar");
      student.setBirthdate(new Birthdate(9,21,2000));
		list.add(student);
		//System.out.println("list contains: " + list);
		list.display();
		System.out.println("list has " + list.getCount());

		}


	}