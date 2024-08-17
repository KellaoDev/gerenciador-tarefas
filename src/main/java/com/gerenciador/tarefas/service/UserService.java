package com.gerenciador.tarefas.service;

import com.gerenciador.tarefas.entity.Usu;
import com.gerenciador.tarefas.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository IUserRepository;

    //save user in the database
    public Usu saveUser(Usu user) {
        return this.IUserRepository.save(user);
    }

    //update user in the database
    public void updateUser(Usu user) {
        this.IUserRepository.save(user);
    }

    //delete user by id in the database
    public void deleteUser(Usu user) {
        this.IUserRepository.deleteById(user.getId());
    }

    //findAllUsers in the database
    public List<Usu> findAllUsers() {
        return this.IUserRepository.findAll();
    }
}
