package br.com.pagamentos.pagamentos.acoes;

import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;

import java.util.Scanner;

/**
 * @brief Interface que define um contrato para fabricas de detalhes de pagamento.
 * Permite que diferentes tipos de pagamento tenham logicas distintas para coletar
 * informacoes do usuario, aderindo ao Principio Aberto/Fechado (OCP).
 */
public interface DetalhesPagamentoFactory {
    /**
     * @brief Cria um objeto DetalhesPagamento a partir da entrada do usuario.
     * @param scanner O objeto Scanner para leitura da entrada do usuario.
     * @return Um objeto DetalhesPagamento preenchido.
     * @throws IllegalArgumentException se a entrada do usuario for invalida.
     */
    DetalhesPagamento criar(Scanner scanner) throws IllegalArgumentException;
}