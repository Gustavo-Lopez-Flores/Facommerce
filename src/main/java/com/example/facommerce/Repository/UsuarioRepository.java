package com.example.facommerce.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.facommerce.Model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    @Query(value="SELECT * FROM usuarios WHERE email = :email AND senha = :senha", nativeQuery = true)
    public Usuario login(String email, String senha);
}