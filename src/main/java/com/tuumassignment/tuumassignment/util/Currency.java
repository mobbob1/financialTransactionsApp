/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuumassignment.tuumassignment.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author MOB
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Currency {
    EUR,
    SEK,
    GBP,
    USD;

    static public boolean isCurrencyExists(String newCurrency) {
        Currency[] checkCurrency = Currency.values();
        for (Currency currency : checkCurrency) {
            if (currency.name().equals(newCurrency)) {
                return true;
            }
        }
         System.out.println("Invalid Currency " + newCurrency);
        return false;
    }
}
