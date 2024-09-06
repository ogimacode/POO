//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal owl = new Owl();
        Animal lion = new Lion();
        Animal wolf = new Wolf();

        zoo.addAnimal(owl);
        zoo.addAnimal(lion);
        zoo.addAnimal(wolf);

        System.out.println(zoo);

        lion.makeSound();
        owl.makeSound();
        wolf.makeSound();
    }
}