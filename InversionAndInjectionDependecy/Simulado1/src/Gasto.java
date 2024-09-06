import java.util.Objects;

public abstract class Gasto {
    private long id;
    private String descricao;
    private double valor;
    private  String cnpj;

    public Gasto(long id, String descricao, double valor, String cnpj) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gasto gasto = (Gasto) o;
        return id == gasto.id && Double.compare(valor, gasto.valor) == 0 && Objects.equals(descricao, gasto.descricao) && Objects.equals(cnpj, gasto.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, cnpj);
    }
}
