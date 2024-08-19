package com.gerenciador.tarefas.service;

import com.gerenciador.tarefas.entity.Usu;
import com.gerenciador.tarefas.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository IUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //save user in the database with password encrypted
    public Usu saveUser(Usu user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.IUserRepository.save(user);
    }

    //update user in the database with password encrypted
    public void updateUser(Usu user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
