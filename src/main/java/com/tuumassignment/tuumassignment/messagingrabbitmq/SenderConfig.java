/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuumassignment.tuumassignment.messagingrabbitmq;

/**
 *
 * @author MOB
 */
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Value("${queue.name}")
    private String message;

    @Bean
    public Queue queue() {
        return new Queue(message, true);
    }

}
