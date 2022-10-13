/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuumassignment.tuumassignment.mappers;

import com.tuumassignment.tuumassignment.model.Account;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author MOB
 */
@Mapper
public interface AccountMapper {

    //GET ACCOUNT BY ACCOUNT ID
    @Select("select * from Account where accountid=#{id}")
    Account findAccountById(int id);

    //GET ACCOUNT BALANCE BY ACCOUNT ID
    @Select("select balance from Account where accountid=#{id}")
    double accountBalanceById(int id);

//CREATE ACCOUNT
    @Insert("INSERT INTO account(customer, currency, balance, country)VALUES(#{customer},#{currency},"
            + "#{balance}, #{country})")
    void insertAccount(Account account);

}
