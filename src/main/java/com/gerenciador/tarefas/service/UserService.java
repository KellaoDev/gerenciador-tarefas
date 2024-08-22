package com.gerenciador.tarefas.service;

import com.gerenciador.tarefas.entity.Usu;
import com.gerenciador.tarefas.repository.IRoleRepository;
import com.gerenciador.tarefas.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private IUserRepository IUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleRepository IRoleRepository;

    //save user in the database with password encrypted
    public Usu saveUser(Usu user) {
        user.setRoles(user.getRoles()
                .stream()
                .map(role -> IRoleRepository.findByName(role.getName()))
                .toList());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.IUserRepository.save(user);
    }

    //update user in the database with password encrypted
    public Usu updateUser(Usu user) {
        user.setRoles(user.getRoles()
                .stream()
                .map(role -> IRoleRepository.findByName(role.getName()))
                .toList());
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.IUserRepository.save(user);
    }

    //FindUserById in database
    public Optional<Usu> findUserById(Long userId) {
        return this.IUserRepository.findById(userId);
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
