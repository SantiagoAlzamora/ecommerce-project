/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.controllers;

import com.ecommerce.entities.Cart;
import com.ecommerce.entities.Product;
import com.ecommerce.services.CartService;
import com.ecommerce.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private CartService cartService;

    @PostMapping("")
    public Cart createCart(@RequestBody Cart cart) {

        try {
            
            return cartService.save(cart);
            
        } catch (Exception e) {
            return null;
        }

    }

//    @GetMapping("/{idCart}")
//    public List<Product> getAllProductsFromCart(@PathVariable int idCart) {
//
//        try {
//            return productService.findAll();
//        } catch (Exception e) {
//            return null;
//        }
//
//    }

//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable int id) {
//
//        try {
//            Product searchedProduct = productService.findProductById(id);
//            return searchedProduct;
//        } catch (Exception e) {
//            return null;
//        }
//
//    }
//
//    @PutMapping("/{id}")
//    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
//
//        try {
//            Product updatedProduct = productService.update(id, product);
//            return updatedProduct;
//        } catch (Exception e) {
//            return null;
//        }
//
//    }
//
//    @DeleteMapping("/{id}")
//    public String updateProduct(@PathVariable int id) {
//
//        try {
//            productService.delete(id);
//            return "Product deleted successfuly";
//        } catch (Exception e) {
//            return null;
//        }
//
//    }

}
