/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto1.repository;

import com.reto1.repository.crud.UserCrudRepository;
import ch.qos.logback.core.util.OptionHelper;
import com.reto1.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository repository;
    
    public List<User> getAll(){
        return (List<User>)repository.findAll();
    }
    
    public Optional<User> getUser(int id){
        return repository.findById(id);
    }
    public User save(User user){
        return repository.save(user);
    }
    public boolean existeEmail(String email){
        Optional<User> usuario= repository.findByEmail(email);
        return usuario.isPresent();
    } 
    
    public Optional<User> autencacionUsuario(String email,String password){
        return repository.findByEmailAndPassword(email, password);
    }
}

