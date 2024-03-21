package com.springbooteshop.SpringBootEShop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbooteshop.SpringBootEShop.model.Customer;

@Repository
public interface BillingRepository extends CrudRepository<Customer, Long> {

}
