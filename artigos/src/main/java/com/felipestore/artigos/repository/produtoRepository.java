package com.felipestore.artigos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipestore.artigos.model.Produtos;

public interface produtoRepository extends JpaRepository<Produtos, Integer>{

}
