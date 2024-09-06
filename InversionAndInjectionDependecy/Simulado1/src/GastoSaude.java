public final class  GastoSaude extends Gasto{
    private String nomeConselho;

    public static double DEDUCAO_MAX_SAUDE = 1500.0;

    public GastoSaude(long id, String descricao, double valor, String cnpj, String nomeConselho) {
        super(id, descricao, valor, cnpj);
        this.nomeConselho = nomeConselho;
    }
}
