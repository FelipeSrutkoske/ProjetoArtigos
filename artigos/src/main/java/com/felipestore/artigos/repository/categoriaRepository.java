package com.felipestore.artigos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipestore.artigos.model.Categorias;

public interface categoriaRepository extends JpaRepository<Categorias, Integer>{

}
