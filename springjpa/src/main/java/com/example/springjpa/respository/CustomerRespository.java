package com.example.springjpa.respository;


import com.example.springjpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRespository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String name);
}