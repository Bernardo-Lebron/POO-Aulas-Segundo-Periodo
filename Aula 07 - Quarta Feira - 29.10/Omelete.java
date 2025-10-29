import java.util.List;

public class Omelete extends Produto {
    private List<Ingrediente> ingredientes;

    public Omelete(String nome, float preco, List<Ingrediente> ingredientes) {
        super(nome, preco);
        this.ingredientes = ingredientes;
    }
}
