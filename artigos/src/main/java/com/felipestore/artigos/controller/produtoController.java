package com.felipestore.artigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipestore.artigos.dto.ProdutosRequestDTO;
import com.felipestore.artigos.model.Categorias;
import com.felipestore.artigos.model.Produtos;
import com.felipestore.artigos.repository.categoriaRepository;
import com.felipestore.artigos.repository.produtoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/produtos")
public class produtoController {

    @Autowired
    private produtoRepository repository;

    @Autowired
    private categoriaRepository catrepository;

    @GetMapping
    public List<Produtos> findAll(){
        return this.repository.findAll();
    }

    @Operation(description = "Busca o produto pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto inserido com sucesso"),
    })
    @GetMapping("/{id}")
    public Produtos findById(@PathVariable Integer id){
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto nao encontrado"));
    }
    
    @Operation(description = "Insere o produto no Estoque")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna o produto"),
        @ApiResponse(responseCode = "400", description = "Nao existe o produto com o ID informado")
    })
    @PostMapping("/save")
    public Produtos save(@RequestBody ProdutosRequestDTO dto){
        Categorias categoria = this.catrepository.findById(dto.getId_categoria()).orElse(null);
        Produtos produto = new Produtos();
        produto.setCategorias(categoria);
        produto.setDescricao(dto.getDescricao());
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade_estoque(dto.getQuantidade_estoque());
        this.repository.save(produto);
        return produto;
    }
}
