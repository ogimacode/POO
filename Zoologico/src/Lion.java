public class Lion extends Animal{

    private String name = "Lion";
    @Override
    public void makeSound(){
        System.out.println("Lion says: Rrrrrrwaaarrr");
    }
    public void run(){
        System.out.println("Lion is running");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
