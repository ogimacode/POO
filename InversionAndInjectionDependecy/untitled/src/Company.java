public class Company {

    Repository repository;

    public Company(Repository repository) {
        this.repository = repository;
    }

    public void hire(){
        repository.hire();
    }
    public void fire(){
        repository.fire();

    }
    public void deploy(){
        repository.deploy();
    }

    public void commit(){
        repository.commit();
    }


}
