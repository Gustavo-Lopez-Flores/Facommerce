package com.example.facommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facommerce.Model.Pagamento;
import com.example.facommerce.Repository.PagamentoRepository;

import java.time.LocalDateTime;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Iterable<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento cadastrar(Pagamento pagamento) {
        pagamento.setDataPagamento(LocalDateTime.now());
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscarPorId(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public Pagamento atualizar(Long id, Pagamento pagamentoAtualizado) {
        Pagamento pagamento = buscarPorId(id);
        pagamento.setPedido(pagamentoAtualizado.getPedido());
        pagamento.setValor(pagamentoAtualizado.getValor());
        pagamento.setDataPagamento(pagamentoAtualizado.getDataPagamento());
        pagamento.setMetodoPagamento(pagamentoAtualizado.getMetodoPagamento());
        return pagamentoRepository.save(pagamento);
    }

    public void deletar(Long id) {
        Pagamento pagamento = buscarPorId(id);
        pagamentoRepository.delete(pagamento);
    }
}