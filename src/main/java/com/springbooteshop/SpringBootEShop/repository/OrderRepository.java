package com.springbooteshop.SpringBootEShop.repository;

import com.springbooteshop.SpringBootEShop.model.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

  ArrayList<Order> findByOrderDate(LocalDate term);

  ArrayList<Order> findOrdersById(Long id);
}
