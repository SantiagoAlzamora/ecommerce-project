/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author santi
 */
@Component
@Data
public class Message {
    
    private Integer statusCode;
    private String text;
    
}
