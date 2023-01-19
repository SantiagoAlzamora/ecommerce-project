/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.services;

import com.ecommerce.entities.Cart;
import com.ecommerce.entities.User;
import com.ecommerce.repositories.UserRepository;
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
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }
    
    @Transactional
    public User update(int id, User user) throws Exception{
        User serchedUser = findUserById(id);
        serchedUser.setUsername(user.getUsername());
        serchedUser.setPassword(user.getPassword());
        return userRepository.save(serchedUser);
    }
    
    @Transactional
    public void delete(int id){
        userRepository.deleteById(id);
    }
    
    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }
    
    @Transactional
    public User findUserById(int id) throws Exception{
       Optional<User> optionalUser = userRepository.findById(id);
       if(optionalUser.isPresent()){
           return optionalUser.get();
       }
       throw new Exception("User not found");
    }
    
    
    
}
