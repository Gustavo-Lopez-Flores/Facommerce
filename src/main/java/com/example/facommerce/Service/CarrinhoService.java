package com.example.facommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facommerce.Model.Carrinho;
import com.example.facommerce.Repository.CarrinhoRepository;

import java.time.LocalDateTime;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Iterable<Carrinho> listarTodos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho cadastrar(Carrinho carrinho) {
        carrinho.setDataCriacao(LocalDateTime.now());
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho buscarPorId(Long id) {
        return carrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    public Carrinho atualizar(Long id, Carrinho carrinhoAtualizado) {
        Carrinho carrinho = buscarPorId(id);
        carrinho.setUsuario(carrinhoAtualizado.getUsuario());
        carrinho.setDataCriacao(carrinhoAtualizado.getDataCriacao());
        carrinho.setItens(carrinhoAtualizado.getItens());
        return carrinhoRepository.save(carrinho);
    }

    public void deletar(Long id) {
        Carrinho carrinho = buscarPorId(id);
        carrinhoRepository.delete(carrinho);
    }
}