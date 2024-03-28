package com.springbooteshop.SpringBootEShop.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBooks {

  private Customer customer;
  private List<Book> books;
}
