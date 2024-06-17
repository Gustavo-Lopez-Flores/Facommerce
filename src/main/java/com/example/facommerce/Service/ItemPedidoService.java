package com.example.facommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facommerce.Model.ItemPedido;
import com.example.facommerce.Repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Iterable<ItemPedido> listarTodos() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido cadastrar(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido buscarPorId(Long id) {
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item do Pedido não encontrado"));
    }

    public ItemPedido atualizar(Long id, ItemPedido itemPedidoAtualizado) {
        ItemPedido itemPedido = buscarPorId(id);
        itemPedido.setPedido(itemPedidoAtualizado.getPedido());
        itemPedido.setProduto(itemPedidoAtualizado.getProduto());
        itemPedido.setQuantidade(itemPedidoAtualizado.getQuantidade());
        itemPedido.setPrecoUnitario(itemPedidoAtualizado.getPrecoUnitario());
        return itemPedidoRepository.save(itemPedido);
    }

    public void deletar(Long id) {
        ItemPedido itemPedido = buscarPorId(id);
        itemPedidoRepository.delete(itemPedido);
    }
}