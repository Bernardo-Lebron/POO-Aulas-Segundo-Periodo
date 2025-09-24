package br.com.pagamentos.pagamentos.modelo;

/**
 * Interface marcadora para detalhes de pagamento especificos.
 * Permite que cada metodo de pagamento exija um tipo especifico de detalhes,
 * mantendo o contrato de ProcessadorPagamento mais generico com DetalhesPagamento.
 * Isso auxilia na aderencia ao LSP (Liskov Substitution Principle) e DIP.
 */
public sealed interface DetalhesEspecificosPagamento extends DetalhesPagamento permits DetalhesPix, DetalhesCartaoCredito, DetalhesTransferenciaBancaria {
    // Sealed interface para controle de herança, conforme Java 17+
}