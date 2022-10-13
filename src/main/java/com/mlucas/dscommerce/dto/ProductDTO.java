package com.mlucas.dscommerce.dto;

import com.mlucas.dscommerce.entities.Product;

public class ProductDTO {

  private Long id;
  private String name;
  private String description;
  private Double price;
  private String imgUrl;

  public ProductDTO() {
  }

  public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
  }

  public ProductDTO(Product entity) {
    id = entity.getId();
    name = entity.getName();
    description = entity.getDescription();
    price = entity.getPrice();
    imgUrl = entity.getImgUrl();
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public Double getPrice() {
    return this.price;
  }

  public String getImgUrl() {
    return this.imgUrl;
  }

}