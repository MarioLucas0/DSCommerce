package com.mlucas.dscommerce.dto;

import com.mlucas.dscommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

  private Long id;

  @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracters")
  @NotBlank(message = "Campo Obrigatorio")
  private String name;

  @Size(min = 10, message = "a descricao precisa ter de 10 caracters")
  @NotNull(message = "Campo Opcional")
  private String description;

  @Positive(message = "o preco precisa ser positivo")
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