package br.com.pagamentos;

import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;
import br.com.pagamentos.pagamentos.modelo.ResultadoTransacao;

/**
 * Interface que define o contrato para qualquer metodo de pagamento.
 * Aplica o Principio da Segregacao de Interfaces (ISP), mantendo-a coesa.
 * Tambem e o coracao do Padrao Strategy e do Principio da Inversao de Dependencia (DIP).
 */
public interface IMetodoPagamento {
    ResultadoTransacao processarPagamento(DetalhesPagamento detalhesPagamento);
    String getTipo();
}
