package com.gerenciador.tarefas.controller;

import com.gerenciador.tarefas.entity.Task;
import com.gerenciador.tarefas.request.RegisterTaskRequest;
import com.gerenciador.tarefas.response.CreateTaskResponse;
import com.gerenciador.tarefas.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task-manager")
public class TaskManagerController {

    @Autowired
    private TaskManagerService taskManagerService;

    @PostMapping
    public ResponseEntity<CreateTaskResponse> saveTask(@RequestBody RegisterTaskRequest registerTaskRequest) {
        Task taskSave = taskManagerService.saveTask(registerTaskRequest);

        CreateTaskResponse response = CreateTaskResponse
                .builder()
                .id(taskSave.getId())
                .title(taskSave.getTitle())
                .description(taskSave.getDescription())
                .creator(taskSave.getCreator().getUsername())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
