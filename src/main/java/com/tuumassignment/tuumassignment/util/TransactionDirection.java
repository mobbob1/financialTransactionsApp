/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuumassignment.tuumassignment.util;

/**
 *
 * @author MOB
 */
public enum TransactionDirection {
    IN,
    OUT;
    
    
      static public boolean isTransactionDirectionExists(String newDirection) {
        TransactionDirection[] checkTransactionDirection = TransactionDirection.values();
        for (TransactionDirection transactionDirection : checkTransactionDirection) {
            if (transactionDirection.name().equals(newDirection)) {
                return true;
            }
        }
         System.out.println("Invalid direction " + checkTransactionDirection);
        return false;
    }
}
