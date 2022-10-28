package br.com.encomenda.gerenciaencomenda;

public enum StatusEncomendaEnum {
    AGUARDANDORETIRADA("Aguardando retirada"),
    ENTREGUE("Entregue");

    private String descricao;

    StatusEncomendaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
