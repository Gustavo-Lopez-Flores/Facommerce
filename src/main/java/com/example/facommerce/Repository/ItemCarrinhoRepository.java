package com.example.facommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.ItemCarrinho;

@Repository
public interface ItemCarrinhoRepository extends CrudRepository<ItemCarrinho, Long> {

}