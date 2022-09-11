package com.product.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.product.example.rest.model.Product;
public interface ProductRepositoryInt extends JpaRepository<Product, Long> 
{
}
