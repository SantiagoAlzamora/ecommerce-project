/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.controllers;

import com.ecommerce.entities.User;
import com.ecommerce.services.UserService;
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
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired 
    private UserService userService;
    
    @PostMapping("")
    public User saveUser(@RequestBody User user){
        try {
            User savedUser = userService.save(user);
            return savedUser;
        } catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        try {
            return userService.findUserById(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        try {
            User updatedUser = userService.update(id, user);
            return updatedUser;
        } catch (Exception e) {
            return null;
        }
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        try {
            userService.delete(id);
            return "User deleted successfuly";
        } catch (Exception e) {
            return null;
        }
    }
    
}
