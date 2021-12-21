/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto1.controller;

import com.reto1.model.User;
import com.reto1.service.UserService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserControler {
    @Autowired
    private UserService service;
    
    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }
    @PostMapping("/new")
    public ResponseEntity addProducto(@RequestBody User usuario){
        service.registrar(usuario);
        return  ResponseEntity.status(201).build();
    }
    
    @GetMapping("/{email}/{password}")
    public User autenticar(@PathVariable("email")String email,@PathVariable("password")String password){
        return service.autenticar(email, password);
    }
    
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return service.exiteEmail(email);
    }
    
}
