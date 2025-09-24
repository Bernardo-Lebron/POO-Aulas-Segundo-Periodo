package br.com.pagamentos.pagamentos;

import br.com.pagamentos.IMetodoPagamento;
import br.com.pagamentos.pagamentos.impl.PagamentoCartaoCredito;
import br.com.pagamentos.pagamentos.impl.PagamentoPix;
import br.com.pagamentos.pagamentos.impl.PagamentoTransferenciaBancaria;

import java.util.Optional;

/**
 * Fabrica para criar instancias de IMetodoPagamento.
 * Implementa o Padrao Factory Method.
 * Promove o Principio do Aberto/Fechado (OCP) e o Principio da Inversao de Dependencia (DIP).
 * Ao adicionar um novo metodo de pagamento, basta estender esta fabrica ou
 * ter um mecanismo de registro (como Spring DI ou um Map<String, Supplier<IMetodoPagamento>>).
 * Para este exemplo didatico, usamos um switch simples.
 * Aplica "Nao usar null" (Object Calisthenics) ao retornar Optional.
 */
public class MetodoPagamentoFactory {
    public Optional<IMetodoPagamento> getMetodoPagamento(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "cartaocredito" -> Optional.of(new PagamentoCartaoCredito());
            case "transferenciabancaria" -> Optional.of(new PagamentoTransferenciaBancaria());
            case "pix" -> Optional.of(new PagamentoPix());
            default -> {
                System.err.println("Método de pagamento desconhecido: " + tipo);
                yield Optional.empty();
            }
        };
    }
}