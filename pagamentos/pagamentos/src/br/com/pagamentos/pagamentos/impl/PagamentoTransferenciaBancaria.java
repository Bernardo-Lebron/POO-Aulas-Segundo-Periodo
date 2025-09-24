package br.com.pagamentos.pagamentos.impl;

import br.com.pagamentos.IMetodoPagamento;
import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;
import br.com.pagamentos.pagamentos.modelo.DetalhesTransferenciaBancaria;
import br.com.pagamentos.pagamentos.modelo.ResultadoTransacao;

/**
 * Implementacao concreta para processamento de pagamentos via Transferencia Bancaria.
 * Segue o Principio da Responsabilidade Unica (SRP), focando apenas na logica de transferencia.
 * Parte do Padrao Strategy.
 */
public class PagamentoTransferenciaBancaria implements IMetodoPagamento {
    @Override
    public ResultadoTransacao processarPagamento(DetalhesPagamento detalhesPagamento) {
        if (!(detalhesPagamento instanceof DetalhesTransferenciaBancaria)) {
            System.err.println("Erro: Detalhes de pagamento inválidos para Transferência Bancária.");
            return ResultadoTransacao.falhou("Detalhes de pagamento inválidos para Transferência Bancária.");
        }
        DetalhesTransferenciaBancaria detalhesTB = (DetalhesTransferenciaBancaria) detalhesPagamento;

        System.out.println("Processando pagamento via Transferência Bancária:");
        System.out.println("  Banco: " + detalhesTB.nomeBanco());
        System.out.println("  Conta: " + detalhesTB.numeroConta());
        System.out.println("  Valor: R$ " + detalhesTB.valor());

        if (!detalhesTB.nomeBanco().isEmpty() && !detalhesTB.numeroConta().isEmpty()) {
            System.out.println("Pagamento por transferência bancária aguardando confirmação.");
            return ResultadoTransacao.sucesso("Transferência bancária iniciada. Aguardando confirmação.", "BT-" + System.currentTimeMillis());
        } else {
            System.out.println("Pagamento por transferência bancária recusado: Dados bancários incompletos.");
            return ResultadoTransacao.falhou("Dados bancários incompletos.");
        }
    }

    @Override
    public String getTipo() {
        return "TransferenciaBancaria";
    }
}