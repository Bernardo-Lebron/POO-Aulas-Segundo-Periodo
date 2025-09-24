package br.com.pagamentos.pagamentos.modelo;

/**
 * Record para os detalhes especificos de um pagamento com cartao de credito.
 * Exemplo de Value Object. Todos os campos sao imutaveis apos a criacao.
 */
public record DetalhesCartaoCredito(
        String numeroCartao,
        String nomeTitularCartao,
        String dataVencimento, // MM/YY
        String cvv,
        double valor) implements DetalhesEspecificosPagamento {

    public DetalhesCartaoCredito {
        if (numeroCartao == null || numeroCartao.isBlank() || numeroCartao.length() != 16) {
            throw new IllegalArgumentException("Número do cartão inválido. Deve ter 16 dígitos.");
        }
        if (nomeTitularCartao == null || nomeTitularCartao.isBlank()) {
            throw new IllegalArgumentException("Nome do titular inválido.");
        }
        if (dataVencimento == null || dataVencimento.isBlank() || !dataVencimento.matches("\\d{2}/\\d{2}")) {
            throw new IllegalArgumentException("Data de expiração inválida (formato MM/AA).");
        }
        if (cvv == null || cvv.isBlank() || cvv.length() != 3) {
            throw new IllegalArgumentException("CVV inválido. Deve ter 3 dígitos.");
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