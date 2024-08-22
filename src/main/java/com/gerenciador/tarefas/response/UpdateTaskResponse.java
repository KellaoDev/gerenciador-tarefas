package com.gerenciador.tarefas.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateTaskResponse {

    private Long id;
    private String title;
    private String description;
    private String taskStatus;
    private String creator;
    private String responsible;
    private int numberEstimatedHours;
    private Integer numberRealizeHours;

}
