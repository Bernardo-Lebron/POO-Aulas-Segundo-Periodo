package br.com.pagamentos.pagamentos.impl;

import br.com.pagamentos.IMetodoPagamento;
import br.com.pagamentos.pagamentos.modelo.DetalhesCartaoCredito;
import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;
import br.com.pagamentos.pagamentos.modelo.ResultadoTransacao;

/**
 * Implementacao concreta para processamento de pagamentos via Cartao de Credito.
 * Segue o Principio da Responsabilidade Unica (SRP), focando apenas na logica de cartao de credito.
 * Parte do Padrao Strategy.
 */
public class PagamentoCartaoCredito implements IMetodoPagamento {
    @Override
    public ResultadoTransacao processarPagamento(DetalhesPagamento detalhesPagamento) {
        if (!(detalhesPagamento instanceof DetalhesCartaoCredito)) {
            System.err.println("Erro: Detalhes de pagamento inválidos para Cartão de Crédito.");
            return ResultadoTransacao.falhou("Detalhes de pagamento inválidos para Cartão de Crédito.");
        }
        DetalhesCartaoCredito detalhesCC = (DetalhesCartaoCredito) detalhesPagamento;

        System.out.println("Processando pagamento via Cartão de Crédito:");
        System.out.println("  Número do Cartão: " + detalhesCC.numeroCartao().replaceAll("(\\d{4})(?=\\d)", "$1-XXXX-XXXX-"));
        System.out.println("  Titular: " + detalhesCC.nomeTitularCartao());
        System.out.println("  Valor: R$ " + detalhesCC.valor());

        if (detalhesCC.numeroCartao().length() == 16 && detalhesCC.cvv().length() == 3) {
            System.out.println("Pagamento com cartão de crédito aprovado!");
            return ResultadoTransacao.sucesso("Pagamento com cartão de crédito aprovado.", "CC-" + System.currentTimeMillis());
        } else {
            System.out.println("Pagamento com cartão de crédito recusado: Dados inválidos.");
            return ResultadoTransacao.falhou("Dados do cartão de crédito inválidos.");
        }
    }

    @Override
    public String getTipo() {
        return "CartaoCredito";
    }
}
