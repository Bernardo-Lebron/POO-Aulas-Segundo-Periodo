package repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Ingrediente;

public class IngredienteRepository {
    private Map<String, Ingrediente> ingredientes = new HashMap<>(); 

    public void adicionarIngrediente(Ingrediente ingrediente) {
        ingredientes.put(ingrediente.getNome(), ingrediente);
    }

    public Ingrediente buscarIngredientePorNome(String nome) {
        return ingredientes.get(nome);
    }

    public List<Ingrediente> listarTodosIngredientes() {
        return new ArrayList<>(ingredientes.values());
    }

    public void removerIngrediente(String nome) {
        ingredientes.remove(nome);
    }
}