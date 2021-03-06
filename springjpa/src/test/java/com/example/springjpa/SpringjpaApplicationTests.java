package com.example.springjpa;

import com.example.springjpa.model.Customer;
import com.example.springjpa.respository.CustomerRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringjpaApplicationTests{
    Logger log= LoggerFactory.getLogger(SpringjpaApplication.class);
    @Autowired
    CustomerRespository respository;
    @Before
    public void setUp(){
        respository.save(new Customer("Jack", "Bauer"));
        respository.save(new Customer("Chloe", "O'Brian"));
        respository.save(new Customer("Kim", "Bauer"));
        respository.save(new Customer("David", "Palmer"));
        respository.save(new Customer("Michelle", "Dessler"));

    }

    @Test
    public void saveAndDeleteById() {
        Customer customer = new Customer("张", "三");
        respository.save(customer);
        log.info("add customer By id" + customer.getId());
        Customer out = respository.findById(customer.getId()).orElse(null);
        if (out != null)
            log.info(out.toString());
        else
            log.info("Customer not find!!!");
        respository.deleteById(customer.getId());
        Customer out2 = respository.findById(customer.getId()).orElse(null);
        if (out2 != null)
            log.info(out2.toString());
        else
            log.info("custermer deleted!!!");
    }
    @Test
    public void findByListName(){
        List<Customer> List=respository.findByLastName("");
        log.info(List.toString());
    }


}

