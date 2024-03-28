package com.springbooteshop.SpringBootEShop.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Entity
@Table(name = "orders")
public class Order {

  @Getter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_date", nullable = false)
  private LocalDate orderDate;

  @Getter
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Getter
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "book_id")
  private Book book;

  public Order() {}

  public Order(Long id, LocalDate orderDate, Customer customer, Book book) {
    this.id = id;
    this.orderDate = orderDate;
    this.customer = customer;
    this.book = book;
  }

  @Override
  public String toString() {
    return "Order [id="
        + id
        + ", orderDate="
        + orderDate
        + ", customer="
        + customer
        + ", book="
        + book
        + "]";
  }
}
