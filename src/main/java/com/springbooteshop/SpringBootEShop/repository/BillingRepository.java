package com.springbooteshop.SpringBootEShop.repository;

import com.springbooteshop.SpringBootEShop.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends CrudRepository<Customer, Long> {}
