package br.com.pagamentos.pagamentos.modelo;

import java.util.Objects;
import java.util.Optional;

/**
 * Record para encapsular o resultado de uma transacao de pagamento.
 * Exemplo de Value Object e aplicacao de "encapsular tipos primitivos" (Object Calisthenics)
 * ao ter os resultados como um objeto e nao apenas booleanos ou strings soltas.
 * A imutabilidade garante a seguranca dos dados do resultado.
 */
public record ResultadoTransacao(boolean sucesso, String mensagem, Optional<String> idTransacao) {

    public ResultadoTransacao {
        Objects.requireNonNull(mensagem, "A mensagem da transação não pode ser nula.");
        if (mensagem.isBlank()) {
            throw new IllegalArgumentException("A mensagem da transação não pode ser vazia.");
        }
        if (sucesso && idTransacao.isEmpty()) {
            throw new IllegalArgumentException("Transação bem-sucedida deve ter um ID de transação.");
        }
        if (sucesso && idTransacao.get().isBlank()) {
            throw new IllegalArgumentException("ID da transação não pode ser vazio para transação bem-sucedida.");
        }
        if (!sucesso && idTransacao.isPresent()) {
            System.err.println("Atenção: Uma transação falha não deveria ter um ID de transação, mas um foi fornecido.");
        }
    }

    public static ResultadoTransacao sucesso(String message, String transactionId) {
        return new ResultadoTransacao(true, message, Optional.of(transactionId));
    }

    public static ResultadoTransacao sucesso(String message) {
        return new ResultadoTransacao(true, message, Optional.empty());
    }

    public static ResultadoTransacao falhou(String message) {
        return new ResultadoTransacao(false, message, Optional.empty());
    }
}
