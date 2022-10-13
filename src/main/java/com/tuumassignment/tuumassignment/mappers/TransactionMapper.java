/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuumassignment.tuumassignment.mappers;

import com.tuumassignment.tuumassignment.model.Transaction;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author MOB
 */
@Mapper
public interface TransactionMapper {


//CREATE TRANSACTION
    @Insert("INSERT INTO transaction(accountid, amount,currency, transactiondirection, description)VALUES(#{accountid},#{amount},"
            + "#{currency}, #{transactiondirection} , #{description})")
    void createTransaction(Transaction transaction);
    
    
          //GET TRANSACTION(s) BY ACCOUNT ID
    @Select("select * from Transaction where transactionId=#{id}")
    List<Transaction> transactionsByAccountId(int id);
    
    

}
