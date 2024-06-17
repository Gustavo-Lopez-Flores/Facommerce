package com.example.facommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long> {

}