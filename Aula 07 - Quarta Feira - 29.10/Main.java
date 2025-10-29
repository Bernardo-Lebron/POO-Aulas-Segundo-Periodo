import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// Nota: Em um projeto real, utilizaríamos BigDecimal para valores monetários 
// e LocalDateTime para datas/horas, mas manteremos Float e String conforme o diagrama.

// ----------------------------------------------------------------------
// I. ENTIDADES DE DOMÍNIO
// ----------------------------------------------------------------------

/**
 * Entidade Cliente.
 */
class Cliente {
    private String nome;
    private String dataDeAniversario; 
    private String cepC; 
    private List<Pedido> pedidos; // Contains [0..*]

    public Cliente(String nome, String dataDeAniversario, String cepC) {
        this.nome = nome;
        this.dataDeAniversario = dataDeAniversario;
        this.cepC = cepC;
        this.pedidos = new ArrayList<>();
    }

    // Getters conforme diagrama
    public String getNome() { return nome; }
    public String getCepC() { return cepC; }
    public String getDataDeAniversario() { return dataDeAniversario; }

    // Métodos conforme diagrama
    public void adicionarPedido(Pedido pedido) { this.pedidos.add(pedido); }
    // Implementação de exemplo, com base na assinatura do diagrama.
    public String criarPedido(ItemPedido[] itens) {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        Pedido novoPedido = new Pedido(dataHora, "Novo");
        for (ItemPedido item : itens) {
            novoPedido.adicionarItemPedido(item);
        }
        this.adicionarPedido(novoPedido);
        return "Pedido criado para " + this.nome + ". Valor: R$ " + novoPedido.getValorFinal();
    }
    public void executar() { /* Lógica de execução do cliente */ }

    @Override
    public String toString() {
        return "Cliente{" + "nome='" + nome + '\'' + ", totalPedidos=" + pedidos.size() + '}';
    }
}

/**
 * Entidade Pedido.
 */
class Pedido {
    private List<ItemPedido> itemPedidos; // Contains [1..*]
    private String dataHora; // Time String (Idealmente LocalDateTime)
    private Float valorFinal;
    private String status;

    public Pedido(String dataHora, String status) {
        this.dataHora = dataHora;
        this.status = status;
        this.itemPedidos = new ArrayList<>();
        this.valorFinal = 0.0f;
    }

    // Getters conforme diagrama
    public String getDataHora() { return dataHora; }
    public Float getValorFinal() { return valorFinal; }
    public String getStatus() { return status; }
    public List<ItemPedido> getItemPedidos() { return itemPedidos; }

    // Método para adicionar item e atualizar o valor total
    public void adicionarItemPedido(ItemPedido item) {
        this.itemPedidos.add(item);
        this.valorFinal += item.getValorPedido(); 
    }

    @Override
    public String toString() {
        return "Pedido{" + "dataHora='" + dataHora + '\'' + ", valorFinal=R$" + String.format("%.2f", valorFinal) + '}';
    }
}

/**
 * Entidade ItemPedido.
 */
class ItemPedido {
    private Produto produto; // Contains 1 (Associação Forte)
    private int quantidade;
    private Float totalPedido; // Valor unitário * quantidade

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.totalPedido = produto.getPreco() * quantidade;
    }

    // Getters conforme diagrama
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public Float getTotalPedido() { return totalPedido; }

    // Método conforme diagrama
    public Float getValorPedido() {
        return totalPedido;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "produto=" + produto.getNome() + ", qtd=" + quantidade + ", total=R$" + String.format("%.2f", totalPedido) + '}';
    }
}

/**
 * Entidade abstrata Produto (Base).
 */
abstract class Produto {
    private String nome;
    private Float preco; 

    public Produto(String nome, Float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters conforme diagrama
    public String getNome() { return nome; }
    public Float getPreco() { return preco; }
    
    @Override
    public String toString() {
        return "Produto{" + "nome='" + nome + '\'' + ", preco=R$" + String.format("%.2f", preco) + '}';
    }
}

/**
 * Entidade Ingrediente.
 */
class Ingrediente {
    private String nome;

    public Ingrediente(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Ingrediente{" + "nome='" + nome + '\'' + '}';
    }
}

// Subclasses de Produto (Herança/Generalização - Extend)

class Pizza extends Produto {
    private String tamanho;
    private List<Ingrediente> ingredientes; // Contains Ingredientes

    public Pizza(String nome, Float preco, String tamanho) {
        super(nome, preco);
        this.tamanho = tamanho;
        this.ingredientes = new ArrayList<>();
    }
    public String getTamanho() { return tamanho; }
    public void adicionarIngrediente(Ingrediente ingrediente) { this.ingredientes.add(ingrediente); }
}

class Omelete extends Produto {
    private List<Ingrediente> ingredientes; // Contains Ingredientes
    public Omelete(String nome, Float preco) {
        super(nome, preco);
        this.ingredientes = new ArrayList<>();
    }
    public void adicionarIngrediente(Ingrediente ingrediente) { this.ingredientes.add(ingrediente); }
}

class Sanduiche extends Produto {
    private String tipo;
    private List<Ingrediente> ingredientes; // Contains Ingredientes

    public Sanduiche(String nome, Float preco, String tipo) {
        super(nome, preco);
        this.tipo = tipo;
        this.ingredientes = new ArrayList<>();
    }
    public String getTipo() { return tipo; }
    public void adicionarIngrediente(Ingrediente ingrediente) { this.ingredientes.add(ingrediente); }
}

class Bebida extends Produto {
    private String tipo;
    private String tamanho;

    public Bebida(String nome, Float preco, String tipo, String tamanho) {
        super(nome, preco);
        this.tipo = tipo;
        this.tamanho = tamanho;
    }
    public String getTipo() { return tipo; }
    public String getTamanho() { return tamanho; }
}

// ----------------------------------------------------------------------
// II. CLASSES DE REPOSITÓRIO (Simulação In-Memory)
// ----------------------------------------------------------------------

class ClienteRepository {
    private Map<String, Cliente> clientes = new HashMap<>(); 
    public void adicionarCliente(Cliente cliente) { clientes.put(cliente.getNome(), cliente); }
    public Cliente buscarClientePorNome(String nome) { return clientes.get(nome); }
}

class ProdutoRepository {
    private Map<String, Produto> produtos = new HashMap<>(); 
    public void adicionarProduto(Produto produto) { produtos.put(produto.getNome(), produto); }
    public Produto buscarProdutoPorNome(String nome) { return produtos.get(nome); }
    public List<Produto> listarTodos() { return new ArrayList<>(produtos.values()); }
}

class PedidoRepository {
    private Map<String, Pedido> pedidos = new HashMap<>(); 
    private int nextId = 1;
    public void adicionarPedido(Pedido pedido) { pedidos.put("ID_" + nextId++, pedido); }
    // Poderia ter buscarPorId, listarPorData, etc.
}

class IngredienteRepository {
    private Map<String, Ingrediente> ingredientes = new HashMap<>();
    public void adicionarIngrediente(Ingrediente ingrediente) { ingredientes.put(ingrediente.getNome(), ingrediente); }
    public Ingrediente buscarIngredientePorNome(String nome) { return ingredientes.get(nome); }
}

// ----------------------------------------------------------------------
// III. CLASSE MAIN PARA DEMONSTRAÇÃO DE USO
// ----------------------------------------------------------------------

public class Main {
    public static void main(String[] args) {
        // Inicialização
        ClienteRepository clienteRepo = new ClienteRepository();
        ProdutoRepository produtoRepo = new ProdutoRepository();
        IngredienteRepository ingredienteRepo = new IngredienteRepository();

        System.out.println("=============================================");
        System.out.println("        DEMONSTRAÇÃO DO MODELO DE CLASSES      ");
        System.out.println("=============================================");

        // 1. Cadastro de Ingredientes e Produtos
        Ingrediente queijo = new Ingrediente("Queijo Muçarela");
        Ingrediente presunto = new Ingrediente("Presunto");
        ingredienteRepo.adicionarIngrediente(queijo);
        ingredienteRepo.adicionarIngrediente(presunto);

        Sanduiche xisSalada = new Sanduiche("X-Salada", 18.00f, "Tradicional");
        xisSalada.adicionarIngrediente(queijo);
        xisSalada.adicionarIngrediente(presunto);
        produtoRepo.adicionarProduto(xisSalada);

        Bebida guaranaLata = new Bebida("Guaraná", 6.50f, "Refrigerante", "350ml");
        produtoRepo.adicionarProduto(guaranaLata);

        Pizza pizzaM = new Pizza("Pizza Mista", 45.00f, "Média");
        pizzaM.adicionarIngrediente(queijo);
        produtoRepo.adicionarProduto(pizzaM);

        System.out.println("\n--- Produtos Cadastrados ---");
        produtoRepo.listarTodos().forEach(System.out::println);
        
        // 2. Cadastro de Cliente
        Cliente cliente = new Cliente("João da Silva", "01/01/1985", "12345-678");
        clienteRepo.adicionarCliente(cliente);
        System.out.println("\n--- Cliente ---");
        System.out.println(cliente.getNome() + " (CEP: " + cliente.getCepC() + ")");

        // 3. Criação do Pedido (usando o método do Cliente)
        System.out.println("\n--- Criação de Pedido ---");
        
        // Simula os itens que seriam passados ao método criarPedido
        ItemPedido itemXis = new ItemPedido(xisSalada, 1);
        ItemPedido itemRefri = new ItemPedido(guaranaLata, 2); 
        ItemPedido itemPizza = new ItemPedido(pizzaM, 1);

        ItemPedido[] itensDoPedido = {itemXis, itemRefri, itemPizza};
        
        // O cliente cria seu próprio pedido, que é adicionado à sua lista
        String resumoPedido = cliente.criarPedido(itensDoPedido);
        System.out.println(resumoPedido);

        // 4. Demonstração de Relacionamento (Cliente -> Pedidos -> Itens -> Produtos)
        System.out.println("\n--- Detalhes do Pedido ---");
        Pedido pedidoRecente = cliente.getPedidos().get(0);
        System.out.println("Status: " + pedidoRecente.getStatus());
        System.out.println("Valor Total: R$ " + String.format("%.2f", pedidoRecente.getValorFinal()));
        System.out.println("Itens:");
        
        for (ItemPedido item : pedidoRecente.getItemPedidos()) {
            System.out.println("- " + item.getQuantidade() + "x " + 
                               item.getProduto().getNome() + 
                               " (" + item.getProduto().getClass().getSimpleName() + 
                               "). Total: R$ " + String.format("%.2f", item.getValorPedido()));
        }

        System.out.println("\n=============================================");
    }
}