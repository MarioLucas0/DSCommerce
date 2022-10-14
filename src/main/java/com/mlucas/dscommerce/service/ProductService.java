package com.mlucas.dscommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mlucas.dscommerce.dto.ProductDTO;
import com.mlucas.dscommerce.entities.Product;
import com.mlucas.dscommerce.repositories.ProductsRepository;
import com.mlucas.dscommerce.service.exceptions.DatabaseException;
import com.mlucas.dscommerce.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

  @Autowired
  private ProductsRepository repository;

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {

    Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    ProductDTO dto = new ProductDTO(product);
    return dto;

  }

  @Transactional(readOnly = true)
  public Page<ProductDTO> findAll(Pageable pageable) {
    Page<Product> result = repository.findAll(pageable);
    return result.map(x -> new ProductDTO(x));
  }

  @Transactional
  public ProductDTO insert(ProductDTO productDto) {

    Product entity = new Product();
    copyDtoToEntity(productDto, entity);
    entity = repository.save(entity);
    return new ProductDTO(entity);
  }

  @Transactional
  public ProductDTO update(ProductDTO productDto, Long id) {

    try {
      Product entity = repository.getReferenceById(id);
      copyDtoToEntity(productDto, entity);
      entity = repository.save(entity);
      return new ProductDTO(entity);

    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Recurso nao encontrado");
    }

  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void deleteById(Long id) {

    try {
      repository.deleteById(id);

    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException("Recurso nao encontrado");
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException("Falha de integridade Referencial");
    }

  }

  private void copyDtoToEntity(ProductDTO productDto, Product entity) {

    entity.setName(productDto.getName());
    entity.setDescription(productDto.getDescription());
    entity.setPrice(productDto.getPrice());
    entity.setImgUrl(productDto.getImgUrl());
  }

}
