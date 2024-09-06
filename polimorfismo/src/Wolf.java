class Wolf extends Animal implements Runner {

    @Override
    public void makeSound() {
        System.out.println("Auuuuuuuuu!");
    }
    @Override
    public void run(){
        System.out.println("Wolf is running!");
    }
}
