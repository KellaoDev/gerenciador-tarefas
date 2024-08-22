package com.gerenciador.tarefas.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterTaskRequest {

    private String title;
    private String description;
    private Long creatorId;
    private int numberEstimatedHours;

}
