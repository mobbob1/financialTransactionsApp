/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuumassignment.tuumassignment.mappers;

import com.tuumassignment.tuumassignment.model.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author MOB
 */
@Mapper
public interface CustomerMapper {

    @Select("select * from Customer")
    List<Customer> findAllCustomers();

    @Select("select * from Customer where customer_id=#{id}")
    Customer findCustomerById(int id);

@Insert("insert into Customer(customer_name) values(#{customer_name})")
    void insertCustomer(Customer customer);

    
    @Update("update Customer set customer_name=#{customer.customer_name} where customer_id=#{id}")
void updateCustomer(Customer customer,int id);

@Delete("delete from Customer where customer_id=#{id}")
void deleteCustomer(Integer id);
}
