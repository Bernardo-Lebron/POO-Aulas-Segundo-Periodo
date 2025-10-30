import java.util.List;

public class Cliente {
    private String nome;
    private String dataDeAniversario;
    private String cep;
    private List<Pedido> pedidos;

    public Cliente(String nome, String dataDeAniversario, String cep) {
        this.nome = nome;
        this.dataDeAniversario = dataDeAniversario;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public String getCep() {
        return cep;
    }

    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    public Pedido criarPedido(List<ItemPedido> itens) {
        Pedido pedido = new Pedido(itens);
        if (pedidos != null) {
            pedidos.add(pedido);
        }
        return pedido;
    }

    public void executar() {
        System.out.println("Executando ações do cliente...");
    }
}