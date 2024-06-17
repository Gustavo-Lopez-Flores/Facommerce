package com.example.facommerce.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}