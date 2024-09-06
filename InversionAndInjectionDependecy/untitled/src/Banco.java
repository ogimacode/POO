import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Banco implements Repository{
    private List<Integer> lista = new ArrayList<>();
    private Services service;

    public Banco() {
        this.service = new Services(lista);
    }

    public void hire(){
        service.hire();
    }
    public void fire(){
        service.fire();
    }
    public void deploy(){
        service.deploy();
    }

   public void commit(){
        service.commit();
   }
}
