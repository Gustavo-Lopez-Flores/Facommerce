package com.example.facommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facommerce.DTO.AddItemDTO;
import com.example.facommerce.Model.Carrinho;
import com.example.facommerce.Model.ItemCarrinho;
import com.example.facommerce.Repository.CarrinhoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @Autowired
    private ProdutoService produtoService;

    public Iterable<Carrinho> listarTodos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho cadastrar() {
        Carrinho carrinho = new Carrinho(usuarioService.buscarPorCpf("12") , LocalDateTime.now());
        //carrinho.setDataCriacao(LocalDateTime.now());
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho buscarPorId(Long id) {
        return carrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    public Carrinho atualizar(Long id, Carrinho carrinhoAtualizado) {
        Carrinho carrinho = buscarPorId(id);
        carrinho.setUsuario(carrinhoAtualizado.getUsuario());
        carrinho.setDataCriacao(carrinhoAtualizado.getDataCriacao());
        carrinho.setItens(carrinhoAtualizado.getItens());
        return carrinhoRepository.save(carrinho);
    }

    public void deletar(Long id) {
        Carrinho carrinho = buscarPorId(id);
        carrinhoRepository.delete(carrinho);
    }

    public List<ItemCarrinho> buscarItensCarrinho(Long id) {
        Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
        if (carrinho.isPresent()) {
            return carrinho.get().getItens();
        }
        return List.of();
    }

    public Double buscarTotalCarrinho(Long id) {
        return carrinhoRepository.findTotalPriceById(id);
    }

    public void adicionarItem(AddItemDTO addItemDTO) {
        ItemCarrinho carrinho = itemCarrinhoService.buscarPorId(addItemDTO.getCarrinhoId());
        if (carrinho == null) {
            carrinho = new ItemCarrinho();
            carrinho.setCarrinho(buscarPorId(addItemDTO.getCarrinhoId()));
            carrinho.setProduto(produtoService.buscarPorId(addItemDTO.getProdutoId()));
            carrinho.setQuantidade(addItemDTO.getQuantidade());
            itemCarrinhoService.cadastrar(carrinho);
        } else {
            carrinho.setQuantidade(carrinho.getQuantidade() + addItemDTO.getQuantidade());
            itemCarrinhoService.atualizar(carrinho.getId(), carrinho);
        }

    }
}