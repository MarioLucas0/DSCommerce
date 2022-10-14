package com.mlucas.dscommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mlucas.dscommerce.dto.ProductDTO;
import com.mlucas.dscommerce.entities.Product;
import com.mlucas.dscommerce.repositories.ProductsRepository;

@Service
public class ProductService {

  @Autowired
  private ProductsRepository repository;

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {
    Product product = repository.findById(id).get();
    ProductDTO dto = new ProductDTO(product);
    return dto;
  }

  @Transactional(readOnly = true)
  public Page<ProductDTO> findAll(Pageable pageable) {
    Page<Product> result = repository.findAll(pageable);
    return result.map(x -> new ProductDTO(x));

  }

}
