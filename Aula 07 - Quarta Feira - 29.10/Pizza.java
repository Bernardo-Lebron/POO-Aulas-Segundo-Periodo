import java.util.List;

public class Pizza extends Produto {
    private String tamanho;
    private List<Ingrediente> ingredientes;

    public Pizza(String nome, float preco, String tamanho, List<Ingrediente> ingredientes) {
        super(nome, preco);
        this.tamanho = tamanho;
        this.ingredientes = ingredientes;
    }

    public String getTamanho() {
        return tamanho;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}

