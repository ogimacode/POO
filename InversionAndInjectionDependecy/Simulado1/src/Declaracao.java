import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract sealed class Declaracao permits DeclaracaoSimplificada, DeclaracaoCompleta {
    private final long id;
    protected double ganhoTributavel;
    private double valorPago;
    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
        this.valorPago = valorPago;
        this.ganhoTributavel = ganhoTributavel;
    }

    public final double getValorAPagar(){
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }

    public double getDespesaDedutivel(){
        return 0;
    }

    public abstract double getValorImposto();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }
}
