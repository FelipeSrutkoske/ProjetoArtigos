package com.felipestore.artigos.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;
    private String nome;
    private String descricao;
    private Integer preco;
    private Integer quantidade_estoque;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categorias;

}
