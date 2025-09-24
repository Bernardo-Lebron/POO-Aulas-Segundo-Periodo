package br.com.pagamentos.pagamentos.modelo;

public record DetalhesPix(String chave,
                          double valor) implements DetalhesEspecificosPagamento{
    public DetalhesPix {
        if (chave == null || chave.isBlank() ) {
            throw new IllegalArgumentException("Chave invalida.");
        }
        this.validarValor(valor);
    }

    @Override
    public void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo.");
        }
    }
}
