package com.felipestore.artigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipestore.artigos.model.Categorias;
import com.felipestore.artigos.repository.categoriaRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/api/categorias")
public class categoriaController {
    @Autowired
    private categoriaRepository catrepository;

    @GetMapping
    public List<Categorias> findAll(){
        return this.catrepository.findAll();
    }
    
    @Operation(description = "Busca a categoria pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto inserido com sucesso"),
    })
    
    @GetMapping("/{id_categoria}")
    public Categorias findById(@PathVariable Integer id_categoria){
        return this.catrepository.findById(id_categoria).orElseThrow(() -> new IllegalArgumentException("Categoria nao encontrada"));
    }

    @PostMapping("/save")
    public Categorias savecategoria(@RequestBody Categorias categoria){
        System.out.println(categoria.getId_categoria());
        this.catrepository.save(categoria);
        return categoria;
    }
}
