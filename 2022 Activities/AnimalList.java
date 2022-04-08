import java.util.Iterator;

public class AnimalList implements Iterator<Animal> {

    Animal[] animals;
    int count;
    int iterate= 0;

    public AnimalList(int size){
        animals = new Animal[size];
        count = 0;
    }

    // default
    public AnimalList(){
        this(10);
    }

    public void add(Animal animal){
        animals[count++] = animal;
    }

    public Animal pop(){
        return animals[count--];
    }

    @Override
    public boolean hasNext() {
        if(animals[0] == null)
            return false;
        return animals[iterate++] != null && count>0;
    }

    @Override
    public Animal next() {
        return animals[iterate];
    }
}
