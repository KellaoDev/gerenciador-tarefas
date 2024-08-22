package com.gerenciador.tarefas.service;

import com.gerenciador.tarefas.entity.Task;
import com.gerenciador.tarefas.repository.TaskManagerRepository;
import com.gerenciador.tarefas.request.RegisterTaskRequest;
import com.gerenciador.tarefas.status.TaskStatusEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskManagerService {

    @Autowired
    private TaskManagerRepository taskManagerRepository;

    @Autowired
    private UserService userService;

    public Task saveTask(RegisterTaskRequest request) {

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .taskStatus(TaskStatusEnum.CREATE)
                .creator(userService.findUserById(request.getCreatorId()).get())
                .numberEstimatedHours(request.getNumberEstimatedHours())
                .build();

        return this.taskManagerRepository.save(task);

    }
}
