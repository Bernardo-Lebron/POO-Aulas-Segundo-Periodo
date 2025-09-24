package br.com.pagamentos.pagamentos.modelo;

/**
 * Record para os detalhes especificos de um pagamento via Transferencia Bancaria.
 * Exemplo de Value Object.
 */
public record DetalhesTransferenciaBancaria(
        String nomeBanco,
        String numeroConta,
        String nomeBeneficiario,
        double valor) implements DetalhesEspecificosPagamento {

    public DetalhesTransferenciaBancaria {
        if (nomeBanco == null || nomeBanco.isBlank()) {
            throw new IllegalArgumentException("Nome do banco inválido.");
        }
        if (numeroConta == null || numeroConta.isBlank()) {
            throw new IllegalArgumentException("Número da conta inválido.");
        }
        if (nomeBeneficiario == null || nomeBeneficiario.isBlank()) {
            throw new IllegalArgumentException("Nome do beneficiário inválido.");
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
