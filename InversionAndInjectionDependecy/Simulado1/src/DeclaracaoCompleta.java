import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DeclaracaoCompleta extends Declaracao{

private List<Gasto> gastos = new ArrayList<>();
    public DeclaracaoCompleta(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
    }

    @Override
    public double getDespesaDedutivel(){

    }

    @Override
    public double getValorImposto(){
        double ganho = getGanhoTributavel();
        double imposto= 0;
        if (ganho > 55_976.16) {
            imposto += (ganho - 55_976.16) * 0.275;
            ganho = 55_976.16;
        }
        if (ganho >= 45_012.73){
            imposto +=(ganho - 45_012.73) * 0.225;
            ganho = 45_012.72;
        }
        if (ganho >= 33_919.93){
            imposto = (ganho - 33_919.93) * 0.15;
            ganho = 33_919.93;
        }
        if (ganho >= 22_847.88){
            imposto = (ganho - 22_847.88) * 0.75;
        }
        return imposto;
    }
    public void addGasto(Gasto gasto){
        Objects.requireNonNull(gasto, "Gasto não pode ser nulo");
        gastos.add(gasto);
    }
    public void removeGasto(Gasto gasto){
        gastos.remove(gasto);
    }

}
