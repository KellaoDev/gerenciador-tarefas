package com.gerenciador.tarefas.response;

import com.gerenciador.tarefas.status.TaskStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class GetTasksResponse {


    private Long id;
    private String title;
    private String description;
    private TaskStatusEnum taskStatus;
    private String responsible;
    private String creator;
    private int numberEstimatedHours;
    private Integer numberRealizeHours;
    private LocalTime dateRegister;
    private LocalTime dateUpdate;

}
