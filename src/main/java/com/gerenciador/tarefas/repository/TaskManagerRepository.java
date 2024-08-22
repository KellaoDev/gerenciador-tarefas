package com.gerenciador.tarefas.repository;

import com.gerenciador.tarefas.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskManagerRepository extends JpaRepository<Task, Long> {

}
