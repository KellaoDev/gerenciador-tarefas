package com.gerenciador.tarefas.service;

import com.gerenciador.tarefas.entity.Task;
import com.gerenciador.tarefas.repository.TaskManagerRepository;
import com.gerenciador.tarefas.request.RegisterTaskRequest;
import com.gerenciador.tarefas.request.UpdateTaskRequest;
import com.gerenciador.tarefas.status.TaskStatusEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class TaskManagerService {

    @Autowired
    private TaskManagerRepository taskManagerRepository;

    @Autowired
    private UserService userService;

    public Task saveTask(RegisterTaskRequest request) {

        Task task = Task.builder().title(request.getTitle()).description(request.getDescription()).taskStatus(TaskStatusEnum.CREATE).creator(userService.findUserById(request.getCreatorId()).get()).numberEstimatedHours(request.getNumberEstimatedHours()).build();

        return this.taskManagerRepository.save(task);

    }

    public Page<Task> getTaskByTitle(String title, Pageable pageable) {
        return this.taskManagerRepository.findByTitleContaining(title, pageable);
    }

    public Page<Task> getAllTask(Pageable pageable) {
        return this.taskManagerRepository.findAll(pageable);
    }

    public Task updateTask(Long id, UpdateTaskRequest request) {

        Task task = this.taskManagerRepository.findById(id).get();

        task.setTitle(request.getTitle());
        task.setTaskStatus(request.getTaskStatus());
        task.setDescription(request.getDescription());
        task.setResponsible(userService.findUserById(request.getResponsibleId()).get());
        task.setNumberEstimatedHours(request.getNumberEstimatedHours());
        task.setNumberRealizeHours(request.getNumberRealizeHours());

        this.taskManagerRepository.save(task);

        return task;
    }

    public void deleteTask(Long id) {
        this.taskManagerRepository.deleteById(id);
    }
}
