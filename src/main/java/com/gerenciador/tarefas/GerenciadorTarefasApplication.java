package com.gerenciador.tarefas;

import com.gerenciador.tarefas.entity.Role;
import com.gerenciador.tarefas.entity.Usu;
import com.gerenciador.tarefas.permissions.RoleEnum;
import com.gerenciador.tarefas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GerenciadorTarefasApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(GerenciadorTarefasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usu usu = new Usu();
        usu.setUsername("admin");
        usu.setPassword("123456");

        List<Role> roles = new ArrayList<>();

        Role roleAdmin = new Role();
        roleAdmin.setName(RoleEnum.ADMIN);

        Role roleUser = new Role();
        roleUser.setName(RoleEnum.USER);

        roles.add(roleAdmin);
        roles.add(roleUser);

        usu.setRoles(roles);

        userService.saveUser(usu);
    }
}
