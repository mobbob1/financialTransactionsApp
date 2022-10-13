/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuumassignment.tuumassignment.controller;

import com.tuumassignment.tuumassignment.mappers.AccountMapper;
import com.tuumassignment.tuumassignment.mappers.TransactionMapper;
import com.tuumassignment.tuumassignment.messagingrabbitmq.QueueSender;
import com.tuumassignment.tuumassignment.model.Account;
import com.tuumassignment.tuumassignment.model.Transaction;
import com.tuumassignment.tuumassignment.util.Currency;
import com.tuumassignment.tuumassignment.util.TransactionDirection;
import java.util.List;
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
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    TransactionMapper transactionMapper;

    @Autowired
    private QueueSender queueSender;

    @PostMapping("/createTransaction")
    public String createTransaction(@RequestBody Transaction transaction) {

        //Checking for invalid Currency
        boolean checkCurrency = Currency.isCurrencyExists(transaction.getCurrency().name());

        if (checkCurrency == false) {

            queueSender.send("Invalid Currency " + transaction.getCurrency().name());
            return "Invalid Currency " + transaction.getCurrency().name();
        }

        //Checking for invalid Direction
        boolean checkDirection = TransactionDirection.isTransactionDirectionExists(transaction.getTransactiondirection().name());

        if (checkDirection == false) {
            queueSender.send("Invalid Direction " + transaction.getTransactiondirection().name());
            return "Invalid Direction " + transaction.getTransactiondirection().name();
        }

        //Checking for invalid amount
        if (transaction.getAmount() < 0) {
            System.out.println("Invalid Amount");
            queueSender.send("Invalid Amount");
            return "Invalid Amount";
        }

        //Insufficient Funds
        double passingBalance = accountMapper.accountBalanceById(transaction.getAccountid());
        if (transaction.getAmount() > passingBalance) {
            queueSender.send("Invalid Amount");
            return "Invalid Amount";
        }

        //Compute the current balance after the transaction amount
        double focusBalance = passingBalance - transaction.getAmount();

        transaction.setBalance(focusBalance);
        //Account Missing

        Account foundAccount = accountMapper.findAccountById(transaction.getAccountid());

        if (ObjectUtils.isEmpty(foundAccount)) {
            queueSender.send("Account Missing");
            return "Account Missing";
        }

        //Description Missing
        if (transaction.getDescription().isEmpty()) {
            queueSender.send("Description Missing");
            return "Description Missing";
        }

        transactionMapper.createTransaction(transaction);

        queueSender.send("Description Missing");
        return "Description Missing";
    }

    //GET A LIST OF TRANSACTIONS BY ACCOUNT ID
    @GetMapping("/findTransactionByAccountId/{id}")
    public List<Transaction> findTransactionByAccountId(@PathVariable("id") int id) {
        Account foundAccount = accountMapper.findAccountById(id);
        if (ObjectUtils.isEmpty(foundAccount)) {
            queueSender.send("Invalid Account");
        }
        return transactionMapper.transactionsByAccountId(id);
    }

}
