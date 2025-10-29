import java.util.*;  

public class abc {
    
    // Interface base para opções de menu
    public interface MenuOption {
        String getTitle();
        void execute();
    }

    // Item simples de menu (executa uma ação)
    public static class MenuItem implements MenuOption {
        private final String title;
        private final Runnable action;

        public MenuItem(String title, Runnable action) {
            this.title = Objects.requireNonNull(title, "O título do menu não pode ser nulo");
            this.action = Objects.requireNonNull(action, "A ação do menu não pode ser nula");
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public void execute() {
            this.action.run();
        }
    }

    // Menu que pode conter várias opções
    public static class Menu implements MenuOption {
        private final String title;
        private final List<MenuOption> options;
        private final Scanner scanner;

        public Menu(String title, Scanner scanner) {
            this.title = Objects.requireNonNull(title, "O título do menu não pode ser nulo");
            this.scanner = Objects.requireNonNull(scanner, "Scanner não pode ser nulo");
            this.options = new ArrayList<>();
        }

        public void addOption(MenuOption option) {
            Objects.requireNonNull(option, "Opção não pode ser nula");
            this.options.add(option);
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public void execute() {
            boolean sair = false;
            while (!sair) {
                exibir();
                System.out.print("Escolha uma opção (ou 0 para sair): ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // consumir quebra de linha

                if (escolha == 0) {
                    sair = true;
                } else if (escolha > 0 && escolha <= options.size()) {
                    options.get(escolha - 1).execute();
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            }
        }

        private void exibir() {
            System.out.println("\n==== " + this.title + " ====");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + " - " + options.get(i).getTitle());
            }
            System.out.println("0 - Sair");
        }
    }

    // Método principal para testar o menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menuPrincipal = new Menu("Menu Principal", sc);
        menuPrincipal.addOption(new MenuItem("Dizer Olá", () -> System.out.println("Olá, mundo!")));
        menuPrincipal.addOption(new MenuItem("Somar 2 + 2", () -> System.out.println("2 + 2 = " + (2 + 2))));
        
        menuPrincipal.execute();
        
        sc.close();
    }
}
