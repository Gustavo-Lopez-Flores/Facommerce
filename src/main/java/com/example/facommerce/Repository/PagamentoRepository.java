package com.example.facommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Pagamento;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

}