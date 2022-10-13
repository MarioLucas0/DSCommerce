package com.mlucas.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlucas.dscommerce.entities.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
