package br.com.pagamentos.pagamentos;

import br.com.pagamentos.IMetodoPagamento;
import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;
import br.com.pagamentos.pagamentos.modelo.ResultadoTransacao;

import java.util.Objects;
import java.util.Optional;

/**
 * Classe principal para processar pagamentos.
 * Usa o Padrao Strategy para delegar o processamento real a uma implementacao de IMetodoPagamento.
 * Adere fortemente ao Principio da Inversao de Dependencia (DIP) e ao Principio do Aberto/Fechado (OCP).
 * A classe ProcessadorPagamento nao precisa ser modificada para suportar novos metodos de pagamento,
 * apenas a fabrica e as implementacoes de IMetodoPagamento precisam ser atualizadas.
 */
public class ProcessadorPagamento {
    private final IMetodoPagamento metodoPagamento;

    public ProcessadorPagamento(IMetodoPagamento metodoPagamento) {
        this.metodoPagamento = Objects.requireNonNull(metodoPagamento, "O método de pagamento não pode ser nulo.");
    }

    public ResultadoTransacao processar(DetalhesPagamento detalhesPagamento) {
        return metodoPagamento.processarPagamento(detalhesPagamento);
    }

    public String getTipoMetodoPagamento() {
        return metodoPagamento.getTipo();
    }

    public static Optional<ProcessadorPagamento> criar(String tipo) {
        MetodoPagamentoFactory fabrica = new MetodoPagamentoFactory();
        Optional<IMetodoPagamento> metodo = fabrica.getMetodoPagamento(tipo);
        return metodo.map(ProcessadorPagamento::new);
    }
}