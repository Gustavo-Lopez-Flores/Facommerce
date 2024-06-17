package com.example.facommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}