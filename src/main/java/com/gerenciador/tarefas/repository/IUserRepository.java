package com.gerenciador.tarefas.repository;

import com.gerenciador.tarefas.entity.Usu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Usu, Long> {

    Optional<Usu> findByUsername(String username);

}
