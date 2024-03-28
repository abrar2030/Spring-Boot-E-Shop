package com.springbooteshop.SpringBootEShop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  @Getter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_date", nullable = false)
  private LocalDate orderDate;

  @Getter
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "customer_id", nullable = false) // Added nullable = false for clarity
  private Customer customer;

  @Getter
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "book_id", nullable = false) // Added nullable = false for clarity
  private Book book;

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
