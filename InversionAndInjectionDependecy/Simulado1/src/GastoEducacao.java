public final class GastoEducacao  extends Gasto{
    private String nomeInstituicao;

    public static double DEDUCAO_MAX_EDUCA = 2000.0;

    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }
}
