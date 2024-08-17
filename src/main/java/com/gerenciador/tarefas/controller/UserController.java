package com.gerenciador.tarefas.controller;

import com.gerenciador.tarefas.entity.Usu;
import com.gerenciador.tarefas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Usu> saveUser(@RequestBody Usu user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public void updateUser(@RequestBody Usu user) {
        userService.updateUser(user);
    }

    @GetMapping
    public ResponseEntity<List<Usu>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody Usu user) {
        userService.deleteUser(user);
    }
}
