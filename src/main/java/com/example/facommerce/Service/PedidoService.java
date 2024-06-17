package com.example.facommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facommerce.Model.Pedido;
import com.example.facommerce.Repository.PedidoRepository;

import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Iterable<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido cadastrar(Pedido pedido) {
        pedido.setDataPedido(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        Pedido pedido = buscarPorId(id);
        pedido.setUsuario(pedidoAtualizado.getUsuario());
        pedido.setDataPedido(pedidoAtualizado.getDataPedido());
        pedido.setTotal(pedidoAtualizado.getTotal());
        pedido.setStatus(pedidoAtualizado.getStatus());
        pedido.setItens(pedidoAtualizado.getItens());
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        Pedido pedido = buscarPorId(id);
        pedidoRepository.delete(pedido);
    }
}