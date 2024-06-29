package com.example.facommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facommerce.DTO.CadastroProdutoDTO;
import com.example.facommerce.Model.Produto;
import com.example.facommerce.Repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Iterable<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto cadastrar(CadastroProdutoDTO produto) {
        System.out.println(produto.getCategoriaId());
        Produto novoProduto = new Produto(
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidade(),
                categoriaService.buscarPorId(produto.getCategoriaId()),
                produto.getImagemUrl()
        );

        return repository.save(novoProduto);
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setImagemUrl(produtoAtualizado.getImagemUrl());
        return repository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        repository.delete(produto);
    }
}