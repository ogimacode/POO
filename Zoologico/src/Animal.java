abstract class Animal {

    private String name;

    public abstract void makeSound();

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
