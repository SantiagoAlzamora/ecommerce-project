/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.services;

import com.ecommerce.entities.Product;
import com.ecommerce.repositories.ProductRepository;
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
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Transactional
    public Product save(Product product){
        return productRepository.save(product);
    }
    
    @Transactional
    public Product update(int id, Product product){
        Product searchedProduct = findProductById(id);
        searchedProduct.setPrice(product.getPrice());
        searchedProduct.setStock(product.getStock());
        searchedProduct.setName(product.getName());
        searchedProduct.setImage(product.getImage());
        return productRepository.save(searchedProduct);
    }
    
    @Transactional
    public void delete(int id){
        productRepository.deleteById(id);
    }
    
    @Transactional
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    
    @Transactional
    public Product findProductById(int id){
       Optional<Product> optionalProduct = productRepository.findById(id);
       if(optionalProduct.isPresent()){
           return optionalProduct.get();
       }
       return null;
    }
    
}
