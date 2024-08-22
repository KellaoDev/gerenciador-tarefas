package com.gerenciador.tarefas.request;

import com.gerenciador.tarefas.status.TaskStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskRequest {

    private String title;
    private String description;
    private TaskStatusEnum taskStatus;
    private Long responsibleId;
    private int numberEstimatedHours;
    private Integer numberRealizeHours;

}
