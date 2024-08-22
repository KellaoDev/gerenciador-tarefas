package com.gerenciador.tarefas.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GetTasksPagedResponse {

    private int pageCurrent;
    private Long totalItems;
    private int totalPages;
    List<GetTasksResponse> tasks;

}
