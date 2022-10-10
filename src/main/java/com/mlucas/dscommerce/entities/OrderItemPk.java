package com.mlucas.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPk {

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public void setOrder(Order order2) {
  }

  public void setProduct(Product product2) {
  }

  public Order getOrder() {
    return null;
  }

  public Product getProduct() {
    return null;
  }
}
