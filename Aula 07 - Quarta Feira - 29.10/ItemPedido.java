public class ItemPedido{
    private Produto produto;
    private int quantidade;
    private float totalPedido;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.totalPedido = quantidade * produto.getPreco();
    }

    public String getProdutoID() {
        return produto.getNome();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValorPedido() {
        return totalPedido;
    }
}