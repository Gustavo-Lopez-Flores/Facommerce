package com.example.facommerce.DTO;

public class CadastroProdutoDTO {
    private String nome;
    private float preco;
    private Long categoriaId;
    private int quantidade;
    private String descricao;
    private String imagemUrl;

    public CadastroProdutoDTO() {
    }

    public CadastroProdutoDTO(String nome, String preco, Long categoriaId, int quantidade, String descricao, String imagemUrl) {
        this.nome = nome;
        this.preco = Float.parseFloat(preco);
        this.categoriaId = categoriaId;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
