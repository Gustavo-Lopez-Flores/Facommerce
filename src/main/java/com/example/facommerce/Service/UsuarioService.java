package com.example.facommerce.Service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facommerce.DTO.CadastroDTO;
import com.example.facommerce.Model.TipoUsuario;
import com.example.facommerce.Model.Usuario;
import com.example.facommerce.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Iterable<Usuario> listarTodos() {
        return repository.findAll();
    }
    
    public Usuario cadastrar(CadastroDTO cadastro) {
        if(repository.findById(cadastro.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
    
        Date dataNascimento = Date.valueOf(cadastro.getDataNascimento());
        Usuario novoUsuario = new Usuario(
            cadastro.getCpf().replaceAll("\\D", ""),
            cadastro.getNome(),
            cadastro.getTelefone().replaceAll("\\D", ""),
            dataNascimento,
            cadastro.getEmail(),
            cadastro.getSenha(),
            TipoUsuario.CLIENTE
        );
        //novoUsuario.setTermo(usuario.termo);
        return repository.save(novoUsuario);
    }

    public Usuario login(String email, String senha) {
        return repository.login(email, senha);
    }

    public Usuario buscarPorCpf(String cpf) {
        return repository.findById(cpf).get();
    }

    public Usuario atualizar(String cpf, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorCpf(cpf);
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setTelefone(usuarioAtualizado.getTelefone());
        usuario.setTipoUsuario(usuarioAtualizado.getTipoUsuario());
        return repository.save(usuario);
    }

    public void deletar(String cpf) {
        Usuario usuario = buscarPorCpf(cpf);
        repository.delete(usuario);
    }
}