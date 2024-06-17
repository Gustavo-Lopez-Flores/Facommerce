package com.example.facommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
  
}