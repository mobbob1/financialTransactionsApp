/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuumassignment.tuumassignment.mappers;

import com.tuumassignment.tuumassignment.model.Country;
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
public interface CountryMapper {

    @Select("select * from Country")
    List<Country> findAllCountry();

    @Select("select * from Country where id=#{id}")
    Country findCountryById(Integer id);

    @Select("select * from Country where name=#{name}")
    Country findCountryByName(String name);

    @Insert("insert into Country(name) values(#{name})")
    void insertCountry(Country country);

    @Update("update Country set name=#{name} where id=#{id}")
    void updateCountry(Country country, int id);

    @Delete("delete from Country where id=#{id}")
    void deleteCountry(Integer id);
}
