package com.mlucas.dscommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlucas.dscommerce.dto.ProductDTO;
import com.mlucas.dscommerce.entities.Product;
import com.mlucas.dscommerce.repositories.ProductsRepository;

@Service
public class ProductService {

  private ProductsRepository repository;

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {
    Product product = repository.findById(id).get();
    ProductDTO dto = new ProductDTO(product);
    return dto;

  }

}
