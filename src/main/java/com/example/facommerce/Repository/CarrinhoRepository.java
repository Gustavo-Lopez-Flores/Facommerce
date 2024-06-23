package com.example.facommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Carrinho;

@Repository
public interface CarrinhoRepository extends CrudRepository<Carrinho, Long> {
    public Optional<Carrinho> findByUsuarioCpf(String usuarioCpf);

    // Retornar o preço total do carrinho
    @Query("SELECT SUM(ic.produto.preco * ic.quantidade) FROM ItemCarrinho ic WHERE ic.carrinho.id = :id")
    public Double findTotalPriceById(Long id);
}