public class Zoo {
    private Animal[] cages = new Animal[10];
    private Macaw arara = new Macaw();
    private Tiger trige = new Tiger();
    private Wolf lobao = new Wolf();
    private Owl cojura = new Owl();
    private Lion gatinho = new Lion();
    private Gorilla golira = new Gorilla();

    public void zoo(){
        cages[0] = arara;
        cages[1] = trige;
        cages[2] = lobao;
        cages[3] = cojura;
        cages[4] = gatinho;
        cages[5] = golira;
        cages[6] = arara;
        cages[7] = trige;
        cages[8] = lobao;
        cages[9] = cojura;
    }
    public void verifyCages() {
        for (Animal animal : cages) {
            animal.makeSound();
            if (animal instanceof Runner) {
                ((Runner) animal).run();
            }
        }
    }
}
