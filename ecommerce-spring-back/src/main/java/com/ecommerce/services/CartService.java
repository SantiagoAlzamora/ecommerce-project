/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.services;

import com.ecommerce.entities.Cart;
import com.ecommerce.entities.Product;
import com.ecommerce.repositories.CartRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */
@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductService productService;
    
    @Transactional
    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }
    
    @Transactional
    public Cart addProductsToCart(List<Product> productList, int idCart) throws Exception{
        Cart cart = findCartById(idCart);
        if(cart == null){
            throw new Exception("The cart doesnt exists");
        }
        Product product = productService.findProductById(idCart);
        cart.getProducts().add(product);
        return cartRepository.save(cart);
    }
    
    @Transactional
    public void delete(int id){
        cartRepository.deleteById(id);
    }
    
    @Transactional
    public List<Cart> findAll(){
        return cartRepository.findAll();
    }
    
    @Transactional
    public Cart findCartById(int id){
       Optional<Cart> optionalCart = cartRepository.findById(id);
       if(optionalCart.isPresent()){
           return optionalCart.get();
       }
       return null;
    }
    
}
