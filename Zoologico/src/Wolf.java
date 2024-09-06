public class Wolf extends Animal{
    private String name = "Wolf";

    @Override
    public void makeSound() {
        System.out.println("Wolf says: Auuuuu baby i'm playing you to night");
    }
    public void run(){
        System.out.println("Wolf is running");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
