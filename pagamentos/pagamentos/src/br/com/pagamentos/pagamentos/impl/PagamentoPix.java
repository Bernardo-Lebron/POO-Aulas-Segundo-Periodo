package br.com.pagamentos.pagamentos.impl;

import br.com.pagamentos.IMetodoPagamento;
import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;
import br.com.pagamentos.pagamentos.modelo.DetalhesPix;
import br.com.pagamentos.pagamentos.modelo.ResultadoTransacao;

public class PagamentoPix implements IMetodoPagamento {
    @Override
    public ResultadoTransacao processarPagamento(DetalhesPagamento detalhesPagamento) {
        if (!(detalhesPagamento instanceof DetalhesPix)) {
            System.err.println("Erro: Detalhes de pagamento inválidos para Pix.");
            return ResultadoTransacao.falhou("Detalhes de pagamento inválidos para Pix.");
        }
        DetalhesPix detalhesPix = (DetalhesPix) detalhesPagamento;

        System.out.println("Processando pagamento via Pix:");
        System.out.println("  Chave: " + detalhesPix.chave());
        System.out.println("  Valor: R$ " + detalhesPix.valor());
        return ResultadoTransacao.sucesso("Pagamento com pix aprovado.", "CC-" + System.currentTimeMillis());
    }

    @Override
    public String getTipo() {
        return "Pix";
    }
}
