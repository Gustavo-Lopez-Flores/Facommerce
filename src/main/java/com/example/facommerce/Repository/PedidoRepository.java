package com.example.facommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}