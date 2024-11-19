package com.example.BrownCoffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BrownCoffee.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
