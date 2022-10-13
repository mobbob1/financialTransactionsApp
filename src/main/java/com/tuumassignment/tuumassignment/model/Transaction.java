/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuumassignment.tuumassignment.model;

import com.tuumassignment.tuumassignment.util.Currency;
import com.tuumassignment.tuumassignment.util.TransactionDirection;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author MOB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private int transactionId;

    private int accountid;

    private double amount;

    private Currency currency;

    private TransactionDirection transactiondirection;

    
    private String description;

    private double balance;

}
