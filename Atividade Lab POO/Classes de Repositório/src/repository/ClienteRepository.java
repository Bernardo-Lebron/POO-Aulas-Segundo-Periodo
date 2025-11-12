package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cliente;

public class ClienteRepository {
    private Map<String, Cliente> clientes = new HashMap<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getNome(), cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        return clientes.get(nome);
    }

    public List<Cliente> listarTodosClientes() {
        return new ArrayList<>(clientes.values());
    }

    public void atualizarCliente(Cliente cliente) {
        clientes.put(cliente.getNome(), cliente);
    }

    public void removerCliente(String nome) {
        clientes.remove(nome);
    }
}




