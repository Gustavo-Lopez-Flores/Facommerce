package com.example.facommerce.DTO;

public class CadastroDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private String dataNascimento;
    private String email;
    private String senha;
    private boolean termo;

    public CadastroDTO() {}

    public CadastroDTO(String nome, String cpf, String telefone, String dataNascimento, String email, String senha, boolean termo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.termo = termo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setTermo(boolean termo) {
        this.termo = termo;
    }

    public boolean getTermo() {
        return termo;
    }
}
