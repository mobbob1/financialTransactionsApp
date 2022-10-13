/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuumassignment.tuumassignment.controller;

import com.tuumassignment.tuumassignment.mappers.AccountMapper;
import com.tuumassignment.tuumassignment.mappers.CountryMapper;
import com.tuumassignment.tuumassignment.mappers.CustomerMapper;
import com.tuumassignment.tuumassignment.messagingrabbitmq.QueueSender;
import com.tuumassignment.tuumassignment.model.Account;
import com.tuumassignment.tuumassignment.model.Country;
import com.tuumassignment.tuumassignment.model.Customer;
import com.tuumassignment.tuumassignment.util.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author MOB
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountsController {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CountryMapper countryMapper;

    @Autowired
    private QueueSender queueSender;

    @PostMapping("/createAccount")
    public String insertAccount(@RequestBody Account account) {

        Customer customer = customerMapper.findCustomerById(account.getCustomer());
        if (ObjectUtils.isEmpty(customer)) {

            queueSender.send("Sorry Customer Does not Exists");
            return "Customer not in the system";
        }
        Country country = countryMapper.findCountryByName(account.getCountry());
        if (ObjectUtils.isEmpty(country)) {

            queueSender.send("Country Does not Exists");
            return "No Country Found";

        }
        boolean checkCurrency = Currency.isCurrencyExists(account.getCurrency().name());

        if (checkCurrency == false) {
            queueSender.send("Invalid Currency " + account.getCurrency().name());
            return "Invalid Currency";

        }

        accountMapper.insertAccount(account);
        queueSender.send("Successfully Created Account");
        return "Successfully";
    }

    @GetMapping("/findAccountById/{id}")
    public Account findAccountById(@PathVariable("id") int id) {
        Account foundAccount = accountMapper.findAccountById(id);
        if (ObjectUtils.isEmpty(foundAccount)) {
              queueSender.send("Account Not Found");  
        }
        queueSender.send("Account Found");
        return accountMapper.findAccountById(id);
    }

}
