package com.ApiRestFull.restaurant_management.services;

import com.ApiRestFull.restaurant_management.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ApiRestFull.restaurant_management.repositories.UserRespository;

import java.util.List;

@Service
public class UserService {
    private final UserRespository repository;

    @Autowired
    public UserService(UserRespository repository) {
        this.repository = repository;
    }

    public List<Users> findAllUsers() {
        return repository.findAll();
    }

    public void saveUser(Users user) {
         repository.save(user);
    }

    public Users findUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public Users updateUser(Long id, Users user) {
        return repository.findById(id).map(client -> {
            client.setName(user.getName());
            client.setEmail(user.getEmail());
            client.setPhone(user.getPhone());
            client.setAddress(user.getAddress());
            return repository.save(client);
        }).orElse(null);
    }



}
