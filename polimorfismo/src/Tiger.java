class Tiger extends Animal implements Runner {

    @Override
    public void makeSound() {
        System.out.println("Rrrrrwaarrr!");
    }
    @Override
    public void run(){
        System.out.println("Tiger is running!");
    }
}
