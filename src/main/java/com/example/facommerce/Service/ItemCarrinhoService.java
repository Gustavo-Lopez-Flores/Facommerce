package com.example.facommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facommerce.Model.ItemCarrinho;
import com.example.facommerce.Repository.ItemCarrinhoRepository;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public Iterable<ItemCarrinho> listarTodos() {
        return itemCarrinhoRepository.findAll();
    }

    public ItemCarrinho cadastrar(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }

    public ItemCarrinho buscarPorId(Long id) {
        return itemCarrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item do Carrinho não encontrado"));
    }

    public ItemCarrinho atualizar(Long id, ItemCarrinho itemCarrinhoAtualizado) {
        ItemCarrinho itemCarrinho = buscarPorId(id);
        itemCarrinho.setCarrinho(itemCarrinhoAtualizado.getCarrinho());
        itemCarrinho.setProduto(itemCarrinhoAtualizado.getProduto());
        itemCarrinho.setQuantidade(itemCarrinhoAtualizado.getQuantidade());
        return itemCarrinhoRepository.save(itemCarrinho);
    }

    public void deletar(Long id) {
        ItemCarrinho itemCarrinho = buscarPorId(id);
        itemCarrinhoRepository.delete(itemCarrinho);
    }
}