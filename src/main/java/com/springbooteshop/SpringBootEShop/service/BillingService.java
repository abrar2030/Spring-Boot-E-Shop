package com.springbooteshop.SpringBootEShop.service;

import com.springbooteshop.SpringBootEShop.model.Book;
import com.springbooteshop.SpringBootEShop.model.Customer;
import com.springbooteshop.SpringBootEShop.model.CustomerBooks;
import com.springbooteshop.SpringBootEShop.model.Order;
import com.springbooteshop.SpringBootEShop.repository.BillingRepository;
import com.springbooteshop.SpringBootEShop.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

  private OrderRepository orderRepository;
  private BillingRepository billingRepository;

  public BillingService(OrderRepository orderRepository, BillingRepository billingRepository) {
    this.orderRepository = orderRepository;
    this.billingRepository = billingRepository;
  }

  public Page<CustomerBooks> findPaginated(Pageable pageable, String term) {

    return page(pageable, term);
  }

  private Page<CustomerBooks> page(Pageable pageable, String term) {
    int pageSize = pageable.getPageSize();
    int currentPage = pageable.getPageNumber();
    int startItem = currentPage * pageSize;

    ArrayList<Order> orders = null;
    List<CustomerBooks> list;

    if (term == null) {
      orders = (ArrayList<Order>) orderRepository.findAll();
    } else {
      LocalDate date = LocalDate.parse(term);
      orders = (ArrayList<Order>) orderRepository.findByOrderDate(date);
    }

    Map<Customer, List<Book>> customerBooksMap =
        orders.stream()
            .collect(
                Collectors.groupingBy(
                    Order::getCustomer, Collectors.mapping(Order::getBook, Collectors.toList())));

    List<CustomerBooks> customerBooks =
        customerBooksMap.entrySet().stream()
            .map(entry -> new CustomerBooks(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());

    if (customerBooks.size() < startItem) {
      list = Collections.emptyList();
    } else {
      int toIndex = Math.min(startItem + pageSize, customerBooks.size());
      list = customerBooks.subList(startItem, toIndex);
    }

    Page<CustomerBooks> orderPage =
        new PageImpl<CustomerBooks>(
            list, PageRequest.of(currentPage, pageSize), customerBooks.size());

    return orderPage;
  }

  @Transactional
  public void createOrder(Customer customer, List<Book> books) {

    billingRepository.save(customer);

    for (Book b : books) {
      Order order = new Order();
      order.setCustomer(customer);
      order.setOrderDate(LocalDate.now());
      order.setBook(b);
      orderRepository.save(order);
    }
  }

  public List<CustomerBooks> findOrdersByCustomerId(Long id) {

    List<Order> orders = (List<Order>) orderRepository.findAll();

    Map<Customer, List<Book>> customerBooksMap =
        orders.stream()
            .collect(
                Collectors.groupingBy(
                    Order::getCustomer, Collectors.mapping(Order::getBook, Collectors.toList())));

    List<CustomerBooks> customerBooks =
        customerBooksMap.entrySet().stream()
            .map(entry -> new CustomerBooks(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());

    customerBooks.stream().filter(c -> c.getCustomer().getId().equals(id)).findAny().isPresent();

    return customerBooks;
  }
}
