package br.com.pagamentos.app;

import br.com.pagamentos.menu.Menu;
import br.com.pagamentos.menu.MenuItem;
import br.com.pagamentos.pagamentos.acoes.DetalhesCartaoCreditoPagamentoFactory;
import br.com.pagamentos.pagamentos.acoes.AcaoPagamento;
import br.com.pagamentos.pagamentos.acoes.DetalhesPixPagamentoFactory;
import br.com.pagamentos.pagamentos.acoes.DetalhesTransferenciaBancariaPagamentoFactory;

import java.util.Scanner;

/**
 * @brief Classe principal para demonstrar o sistema de menu expansivel.
 * Esta classe configura o menu principal e os submenus/opcoes.
 * Novos itens podem ser adicionados aqui sem modificar as classes Menu/MenuItem/AcaoPagamento.
 */
public class Main {
    public static void main(String[] args) {
        // Usa um unico Scanner para toda a aplicacao para gerenciar a entrada de forma consistente
        Scanner scanner = new Scanner(System.in);

        try {
            // --- Configuracao do Menu Principal ---
            Menu menuPrincipal = new Menu("Menu Principal", scanner);

            // Adiciona opcoes de pagamento ao menu principal
            // A extensibilidade e demonstrada aqui: para adicionar um novo metodo de pagamento,
            // basta criar a fabrica de detalhes e uma nova AcaoPagamento, sem alterar o Menu.
            menuPrincipal.adicionarOpcao(new AcaoPagamento("Processar Pagamento com Cartão de Crédito", "CartaoCredito", new DetalhesCartaoCreditoPagamentoFactory(), scanner));
            menuPrincipal.adicionarOpcao(new AcaoPagamento("Processar Pagamento com Transferência Bancária", "TransferenciaBancaria", new DetalhesTransferenciaBancariaPagamentoFactory(), scanner));
            menuPrincipal.adicionarOpcao(new AcaoPagamento("Processar Pagamento com Pix", "Pix", new DetalhesPixPagamentoFactory(), scanner));


            // --- Exemplo de Submenu para outras operacoes (e.g., Relatorios) ---
            Menu menuRelatorio = new Menu("Menu de Relatórios", scanner);
            menuRelatorio.adicionarOpcao(new MenuItem("Gerar Relatório Diário", () -> System.out.println("Gerando relatório diário... (Esta é uma simulação)")));
            menuRelatorio.adicionarOpcao(new MenuItem("Gerar Relatório Mensal", () -> System.out.println("Gerando relatório mensal... (Esta é uma simulação)")));
            menuRelatorio.adicionarOpcao(new MenuItem("Gerar Relatório Anual", () -> System.out.println("Gerando relatório anual... (Esta é uma simulação)")));

            // Adiciona o submenu de Relatorios como uma opcao no menu principal
            menuPrincipal.adicionarOpcao(menuRelatorio);

            System.out.println("Bem-vindo ao Terminal do Sistema de Pagamentos!");
            menuPrincipal.executar(); // Inicia o loop do menu principal
            System.out.println("Saindo do Sistema de Pagamentos. Até logo!");
        } catch (Exception e) {
            System.err.println("Ocorreu o seguinte erro na execucao do programa: " + e.getMessage());
        } finally {
            // Fecha o Scanner quando o programa termina
            scanner.close();
        }
    }
}