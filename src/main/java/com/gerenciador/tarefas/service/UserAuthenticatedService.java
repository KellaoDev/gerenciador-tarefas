package com.gerenciador.tarefas.service;

import com.gerenciador.tarefas.entity.Usu;
import com.gerenciador.tarefas.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class UserAuthenticatedService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    public UserDetails loadUserByUsername(String username) {

        //It is important to remember that the user name is reserved by spring security!

        Usu usu = iUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        List<SimpleGrantedAuthority> roles = usu.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().toString()))
                .toList();

        return new User(usu.getUsername(), usu.getPassword(), roles);
    }
}
