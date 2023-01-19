/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.controllers;

import com.ecommerce.entities.Message;
import com.ecommerce.entities.Product;
import com.ecommerce.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santi
 */
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        System.out.println("entre");
        try {
            System.out.println(product);
            Product savedProduct = productService.save(product);
            return ResponseEntity.status(201).body(savedProduct);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body("Error creando");
        }

    }

    @GetMapping("")
    public List<Product> getAllProducts() {

        try {
            return productService.findAll();
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {

        try {
            Product searchedProduct = productService.findProductById(id);
            return searchedProduct;
        } catch (Exception e) {
            return null;
        }

    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {

        try {
            Product updatedProduct = productService.update(id, product);
            return updatedProduct;
        } catch (Exception e) {
            return null;
        }

    }

    @DeleteMapping("/{id}")
    public String updateProduct(@PathVariable int id) {

        try {
            productService.delete(id);
            return "Product deleted successfuly";
        } catch (Exception e) {
            return null;
        }

    }

}
