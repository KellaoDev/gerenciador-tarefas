package com.gerenciador.tarefas.entity;

import com.gerenciador.tarefas.status.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "tasks")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Task implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum taskStatus;
    @Column
    private Usu responsible;
    @Column(nullable = false)
    private Usu creator;
    @Column(nullable = false)
    private int numberEstimatedHours;
    @Column
    private Integer numberRealizeHours;
    @Column
    @CreationTimestamp
    private LocalTime dateRegister;
    @Column
    @UpdateTimestamp
    private LocalTime dateUpdate;

}
