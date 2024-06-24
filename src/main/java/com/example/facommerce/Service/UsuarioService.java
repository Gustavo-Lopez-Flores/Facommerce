package com.example.facommerce.Service;

import java.sql.Date;
import java.util.Optional;

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
        if (repository.findByCpf(cadastro.getCpf()).isPresent()) {
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
        return repository.save(novoUsuario);
    }

    public Usuario login(String email, String senha) {
        Optional<Usuario> usuarioOpt = repository.login(email, senha);
        return usuarioOpt.orElseThrow(() -> new RuntimeException("Email ou senha incorretos"));
    }

    public Usuario buscarPorCpf(String cpf) {
        Optional<Usuario> usuarioOpt = repository.findByCpf(cpf);
        return usuarioOpt.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
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