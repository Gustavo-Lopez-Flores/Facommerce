package com.example.facommerce.DTO;

public class AddItemDTO {
    private Long carrinhoId;
    private Long produtoId;
    private Integer quantidade;

    public AddItemDTO() {}

    public AddItemDTO(Long carrinhoId, Long produtoId, Integer quantidade) {
        this.carrinhoId = carrinhoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Long getCarrinhoId() {
        return carrinhoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
