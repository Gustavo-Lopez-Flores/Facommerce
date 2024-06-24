package com.example.facommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
    Optional<Usuario> login(String email, String senha);

    Optional<Usuario> findByCpf(String cpf);
}