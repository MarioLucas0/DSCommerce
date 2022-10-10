package com.mlucas.dscommerce.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String phone;

  private LocalDate birthDate;

  private String password;

  @OneToMany(mappedBy = "client")
  private List<Order> orders = new ArrayList<>();

  public User() {
  }

  public User(Long id, String name, String phone, LocalDate birthDate, String password) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.birthDate = birthDate;
    this.password = password;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(phone, user.phone)
        && Objects.equals(birthDate, user.birthDate) && Objects.equals(password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, birthDate, password);
  }

}
