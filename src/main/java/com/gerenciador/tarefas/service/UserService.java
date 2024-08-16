package com.gerenciador.tarefas.service;

import com.gerenciador.tarefas.entity.User;
import com.gerenciador.tarefas.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository IUserRepository;

    //save user in the database
    public User saveUser(User user) {
        return this.IUserRepository.save(user);
    }

    //update user in the database
    public void updateUser(User user) {
        this.IUserRepository.save(user);
    }

    //delete user by id in the database
    public void deleteUser(User user) {
        this.IUserRepository.deleteById(user.getId());
    }

    //findAllUsers in the database
    public List<User> findAllUsers() {
        return this.IUserRepository.findAll();
    }
}
