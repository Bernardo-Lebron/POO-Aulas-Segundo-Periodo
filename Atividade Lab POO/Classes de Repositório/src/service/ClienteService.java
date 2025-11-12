package com.exemplo.pedidos.service;

import com.exemplo.pedidos.model.Cliente;
import com.exemplo.pedidos.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() { return clienteRepository.findAll(); }
    public Optional<Cliente> buscarPorId(Long id) { return clienteRepository.findById(id); }
    public Cliente salvar(Cliente c) { return clienteRepository.save(c); }
    public void deletar(Long id) { clienteRepository.deleteById(id); }
}
