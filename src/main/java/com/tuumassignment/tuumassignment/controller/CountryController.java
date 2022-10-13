/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuumassignment.tuumassignment.controller;

import com.tuumassignment.tuumassignment.mappers.CountryMapper;
import com.tuumassignment.tuumassignment.model.Country;
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
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    CountryMapper countryMapper;
    

    @GetMapping("/findAllCountry")
    public List<Country> findAllCountry() {
        return countryMapper.findAllCountry();
    }

    @GetMapping("/findByName/{name}")
    public Country findByName(@PathVariable("name") String name) {
        return countryMapper.findCountryByName(name);
    }

    @PostMapping("/insertCountry")
    public void insertCountry(@RequestBody Country country) {
        countryMapper.insertCountry(country);
    }

 
}
