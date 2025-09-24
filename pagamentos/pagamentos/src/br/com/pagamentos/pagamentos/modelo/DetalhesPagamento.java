package br.com.pagamentos.pagamentos.modelo;

/**
 * Contrato base para os detalhes de pagamento.
 * Encapsula o valor comum a todos os pagamentos.
 * Segue o Principio da Inversao de Dependencia (DIP) ao ser uma abstracao.
 * Exemplo de "encapsular tipos primitivos" (Object Calisthenics) ao ter um BigDecimal ou double como valor.
 */
public interface DetalhesPagamento {
    void validarValor(double valor);
}
