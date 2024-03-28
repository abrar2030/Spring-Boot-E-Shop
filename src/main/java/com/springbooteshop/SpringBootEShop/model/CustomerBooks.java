package com.springbooteshop.SpringBootEShop.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerBooks {

  private Customer customer;
  private List<Book> books;

  public CustomerBooks(Customer customer, List<Book> books) {
    this.customer = customer;
    this.books = books;
  }
}
