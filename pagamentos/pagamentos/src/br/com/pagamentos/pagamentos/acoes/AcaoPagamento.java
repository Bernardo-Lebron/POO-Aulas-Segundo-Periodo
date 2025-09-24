package br.com.pagamentos.pagamentos.acoes;

import br.com.pagamentos.menu.MenuOpcao;
import br.com.pagamentos.pagamentos.ProcessadorPagamento;
import br.com.pagamentos.pagamentos.modelo.DetalhesPagamento;
import br.com.pagamentos.pagamentos.modelo.ResultadoTransacao;

import java.util.Objects;
import java.util.Scanner;

/**
 * @brief Uma implementacao de MenuOption que lida com o processamento de pagamentos.
 * Esta classe atua como um Command, encapsulando a logica de interacao com o usuario
 * para obter detalhes de pagamento e delegar ao ProcessadorPagamento.
 * Permite a adicao de novas opcoes de pagamento sem modificar as classes de menu (OCP).
 */
public class AcaoPagamento implements MenuOpcao {
    private final String titulo;
    // Tipo de metodo de pagamento (e.g., "CartaoCredito")
    private final String tipoMetodoPagamento;
    // Fábrica para obter detalhes de pagamento
    private final DetalhesPagamentoFactory detalhesFactory;
    // Injetado para entrada do usuário
    private final Scanner scanner;

    /**
     * @brief Construtor para AcaoPagamento.
     * @param titulo O titulo da acao de pagamento.
     * @param tipoMetodoPagamento O tipo de metodo de pagamento (usado para instanciar o ProcessadorPagamento).
     * @param detalhesFactory Uma fabrica responsavel por criar os detalhes do pagamento a partir da entrada do usuario.
     * @param scanner O objeto Scanner para leitura da entrada do usuario.
     * @throws NullPointerException se qualquer parametro obrigatorio for nulo.
     */
    public AcaoPagamento(String titulo, String tipoMetodoPagamento, DetalhesPagamentoFactory detalhesFactory, Scanner scanner) {
        this.titulo = Objects.requireNonNull(titulo, "O titulo nao pode ser nulo.");
        this.tipoMetodoPagamento = Objects.requireNonNull(tipoMetodoPagamento, "Tipo de metodo de pagamento nao pode ser nulo.");
        this.detalhesFactory = Objects.requireNonNull(detalhesFactory, "Fabrica de detalhes nao pode ser nulo.");
        this.scanner = Objects.requireNonNull(scanner, "Scanner nao pode ser nulo.");
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void executar() {
        System.out.println("\n--- Executando " + titulo + " ---");

        // Tenta criar um ProcessadorPagamento para o tipo de metodo especificado
        ProcessadorPagamento.criar(tipoMetodoPagamento).ifPresentOrElse(
                processadorPagamento -> {
                    try {
                        // Usa a fabrica para criar os detalhes de pagamento a partir da entrada do usuario
                        DetalhesPagamento detalhes = detalhesFactory.criar(scanner);

                        // Processa o pagamento usando o ProcessadorPagamento
                        ResultadoTransacao resultado = processadorPagamento.processar(detalhes);

                        // Exibe o resultado
                        System.out.println("Resultado: " + (resultado.sucesso() ? "Sucesso" : "Falha") + " - " + resultado.mensagem());
                        resultado.idTransacao().ifPresent(id -> System.out.println("ID da Transação: " + id));
                    } catch (IllegalArgumentException e) {
                        // Captura erros de validacao dos detalhes de pagamento ou de formatacao de numero
                        System.err.println("Erro na entrada de dados: " + e.getMessage());
                        System.err.println("Transação falhou.");
                    } catch (Exception e) {
                        // Captura outras excecoes inesperadas durante o processamento
                        System.err.println("Ocorreu um erro inesperado durante o processamento do pagamento: " + e.getMessage());
                        System.err.println("Transação falhou.");
                    }
                },
                () -> System.err.println("Erro: Não foi possível inicializar o processador de pagamento para " + tipoMetodoPagamento)
        );
    }
}