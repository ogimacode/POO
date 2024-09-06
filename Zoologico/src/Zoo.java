import java.util.Arrays;

public class Zoo {
    private Animal[] cages = new Animal[10];

    private int numberOfAnimals;

    public void addAnimal(Animal animal){
        if (numberOfAnimals < 10){
            cages[numberOfAnimals++] = animal;
        } else{
            System.out.println("Full Cages");
        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "cages=" + Arrays.toString(cages) +
                '}';
    }
}
