package repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Produto;

public class ProdutoRepository {
    private Map<String, Produto> produtos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getNome(), produto);
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtos.get(nome);
    }

    public List<Produto> listarTodosProdutos() {
        return new ArrayList<>(produtos.values());
    }

    public void atualizarProduto(Produto produto) {
        produtos.put(produto.getNome(), produto);
    }

    public void removerProduto(String nome) {
        produtos.remove(nome);
    }
}

