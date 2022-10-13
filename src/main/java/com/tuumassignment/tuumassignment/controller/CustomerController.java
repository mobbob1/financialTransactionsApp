/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuumassignment.tuumassignment.controller;

import com.tuumassignment.tuumassignment.model.Customer;
import com.tuumassignment.tuumassignment.mappers.CustomerMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author MOB
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerMapper customerMapper;

    @GetMapping("/findAllCustomers")
    public List<Customer> findAllCustomers() {
        return customerMapper.findAllCustomers();
    }
    
      @PostMapping("/insertCustomer")
  public void insertCustomer(@RequestBody Customer customer){
    customerMapper.insertCustomer(customer);
  }
  
   @PutMapping("/updateCustomer/{id}")
  public void updateCustomer(@RequestBody Customer customer,@PathVariable("id") int id){
    customerMapper.updateCustomer(customer,id);
  }
  
  @DeleteMapping("/deleteCustomer/{id}")
  public void deleteCustomer(@PathVariable("id") int id){
    customerMapper.deleteCustomer(id);
  }
}
