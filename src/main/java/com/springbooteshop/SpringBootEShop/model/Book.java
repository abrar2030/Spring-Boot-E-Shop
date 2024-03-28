package com.springbooteshop.SpringBootEShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  @NotBlank(message = "{book.name.notBlank}")
  private String name;

  @Column(name = "price", nullable = false)
  @NotNull(message = "{book.price.notNull}")
  private BigDecimal price;

  @Column(name = "authors", nullable = false)
  @NotBlank(message = "{book.authors.notBlank}")
  private String authors;

  @Column(name = "isbn", nullable = false)
  @NotBlank(message = "{book.isbn.notBlank}")
  @Pattern(regexp = "\\d{10}|\\d{13}", message = "{book.isbn.size}")
  private String isbn;

  @Column(name = "publisher", nullable = false)
  @NotBlank(message = "{book.publisher.notBlank}")
  private String publisher;

  @Column(name = "published_on", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull(message = "{book.date.notNull}")
  private LocalDate publishedOn;

  // Default constructor
  public Book() {}

  // Parameterized constructor
  public Book(
      Long id,
      String name,
      BigDecimal price,
      String authors,
      String isbn,
      String publisher,
      LocalDate publishedOn) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.authors = authors;
    this.isbn = isbn;
    this.publisher = publisher;
    this.publishedOn = publishedOn;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getAuthors() {
    return authors;
  }

  public void setAuthors(String authors) {
    this.authors = authors;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public LocalDate getPublishedOn() {
    return publishedOn;
  }

  public void setPublishedOn(LocalDate publishedOn) {
    this.publishedOn = publishedOn;
  }

  @Override
  public String toString() {
    return "Book [id="
        + id
        + ", name="
        + name
        + ", price="
        + price
        + ", authors="
        + authors
        + ", isbn="
        + isbn
        + ", publisher="
        + publisher
        + ", publishedOn="
        + publishedOn
        + "]";
  }
}
