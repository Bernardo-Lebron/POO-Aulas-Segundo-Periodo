package repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Pedido;

public class PedidoRepository {
    private Map<String, Pedido> pedidos = new HashMap<>(); 
    private int nextId = 0;

    public void adicionarPedido(Pedido pedido) {
        pedidos.put("pedido_" + nextId++, pedido); 
    }

    public Pedido buscarPedidoPorDataHora(String dataHora) {
        for (Pedido p : pedidos.values()) {
            if (p.getDataHora().equals(dataHora)) {
                return p;
            }
        }
        return null;
    }

    public List<Pedido> listarTodosPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    public void atualizarPedido(String oldDataHora, Pedido updatedPedido) {
        Pedido existing = buscarPedidoPorDataHora(oldDataHora);
        if (existing != null) {
            pedidos.remove(oldDataHora); 
            pedidos.put(updatedPedido.getDataHora(), updatedPedido); 
        }
    }

    public void removerPedido(String dataHora) {
        pedidos.values().removeIf(p -> p.getDataHora().equals(dataHora));
    }
}
