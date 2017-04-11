package com.example.controller;

import dao.CustomerDAO;
import dao.SimpleCustomerDAO;
import model.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rest")
@RestController
public class CustomerRestController {

    CustomerDAO dao = new SimpleCustomerDAO();


    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    @RequestMapping(value = "/customer/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        Customer customer = dao.getCustomer(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
        Customer customer = dao.getCustomer(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            dao.deleteCustomer(id);
            return new ResponseEntity<Customer>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/customer/name/{name}", method = RequestMethod.GET)
    public List<Customer> getCustomerByName(@PathVariable("name") String name) {
        List<Customer> customerList = dao.getAllCustomers();
        List<Customer> resultArray = new ArrayList<>();

        for(Customer customer : customerList){
            if(customer.getFirstName().equalsIgnoreCase(name)){
                resultArray.add(customer);
            }
        }

        if (resultArray == null) {
            return new ArrayList<>();
        }
        return resultArray;
    }

        @RequestMapping(value = "/customer", method = RequestMethod.POST)
        public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        HttpHeaders headers = new HttpHeaders();
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        dao.createCustomer(customer);
        return new ResponseEntity<>(customer,headers,HttpStatus.CREATED);
    }
}
