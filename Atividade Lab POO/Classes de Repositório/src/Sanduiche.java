import java.util.List;

public class Sanduiche extends Produto {
    private String tipo;
    private List<Ingrediente> ingredientes;

    public Sanduiche(String nome, float preco, String tipo, List<Ingrediente> ingredientes) {
        super(nome, preco);
        this.tipo = tipo;
        this.ingredientes = ingredientes;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}