public class Owl extends Animal{

    private String name = "Owl";
    @Override
    public void makeSound() {
        System.out.println("Owl says: Pruu Pruu");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
