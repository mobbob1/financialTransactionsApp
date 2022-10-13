package com.tuumassignment.tuumassignment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@MapperScan("com.tuumassignment.tuumassignment.mappers")
//@MappedTypes({Customer.class})
@SpringBootApplication
public class TuumassignmentApplication {


    
    
   
	public static void main(String[] args) {
		SpringApplication.run(TuumassignmentApplication.class, args);
	}

 

}
