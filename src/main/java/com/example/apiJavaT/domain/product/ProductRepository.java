package com.example.apiJavaT.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

//Esta extendendo a interface do JpaRepository, geralmente interface não possui methodos, mas esta ajuda em SQLs ja possuindo alguns métodos.
public interface ProductRepository extends JpaRepository<Product, String> {}
