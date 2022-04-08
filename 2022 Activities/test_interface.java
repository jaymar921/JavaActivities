public class test_interface{

   public static void main(String... args){
      Animal a1 = new Animal("Jinky","Dog",7);
        Animal a2 = new Animal("Bob","Cat",4);
        Animal a3 = new Animal("Tom","Cat",6);
   
         AnimalList animalList = new AnimalList();
        animalList.add(a1);
        animalList.add(a2);
        animalList.add(a3);

        System.out.println("Iterator");
        for (AnimalList it = animalList; it.hasNext(); ) {
            System.out.println(it.next());

        }
   }
}