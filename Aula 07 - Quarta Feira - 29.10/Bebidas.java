public class Bebidas extends Produto {
    private String tipo;
    private String tamanho;

    public Bebidas(String nome, float preco, String tipo, String tamanho) {
        super(nome, preco);
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamanho() {
        return tamanho;
    }
}
