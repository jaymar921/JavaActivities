public class Animal implements Comparable<Animal>{

    public String name;
    public String type;
    public int age;

    public Animal(String name, String type, int age){
        this.name = name;
        this.type = type;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Animal: "+name+" "+type+ " age -> "+age;
    }

    @Override
    public int compareTo(Animal o) {
        if(this.age > o.age)
            return 1;
        else if(this.age == o.age)
            return 0;
        return -1;
    }
}
