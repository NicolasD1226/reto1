/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto1.service;

import com.reto1.model.User;
import com.reto1.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    public List<User> getAll(){
        return repository.getAll();
    }
    
    public Optional<User> geUser(int id){
        return repository.getUser(id);
    }
    public User registrar (User user){
        if (user.getId() == null){
            if (exiteEmail(user.getEmail())== false){
                return repository.save(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
     
    public boolean exiteEmail (String email){
        return repository.existeEmail(email);
    }
    
    public User autenticar (String email, String password){
        Optional<User> usuario=repository.autencacionUsuario(email, password);
        
       if(usuario.isPresent()){
           return usuario.get();
       }else{
           return new User(email, password,"NO DEFINIDO");
       }
    }
    
    
}
