package com.felipestore.artigos.dto;

import lombok.Data;

@Data
public class ProdutosRequestDTO {
  private String descricao;
  private String nome;
  private Integer preco; 
  private Integer quantidade_estoque;
  private Integer id_categoria;
}
