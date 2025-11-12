package com.exemplo.pedidos.service;

import com.exemplo.pedidos.model.ItemPedido;
import com.exemplo.pedidos.model.Pedido;
import com.exemplo.pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvar(Pedido pedido) {
        float total = 0f;
        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                if (item.getProduto() != null) {
                    Float preco = item.getProduto().getPreco();
                    if (preco != null) {
                        float subtotal = preco * item.getQuantidade();
                        item.setTotalPedido(subtotal);
                        item.setPedido(pedido);
                        total += subtotal;
                    }
                }
            }
        }
        pedido.setValorFinal(total);
        pedido.setDataHora(LocalDateTime.now());
        if (pedido.getStatus() == null) {
            pedido.setStatus("EM_ABERTO");
        }
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public void deletar(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        }
    }
}