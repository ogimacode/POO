class Gorilla extends Animal implements Runner {

    @Override
    public void makeSound() {
        System.out.println("Roaaaar!");
    }
    @Override
    public void run(){
        System.out.println("Gorilla is running!");
    }
}
