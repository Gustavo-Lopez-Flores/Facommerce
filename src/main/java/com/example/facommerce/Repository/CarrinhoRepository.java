package com.example.facommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Carrinho;

@Repository
public interface CarrinhoRepository extends CrudRepository<Carrinho, Long> {

}