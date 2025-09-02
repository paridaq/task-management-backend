package com.service.task_submission_service.modal;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
public class TaskDto {
    private Long id;

    private String title;

    private  String description;

    private  String image;

    private Long assignedUserId;

    private List<String> tags = new ArrayList<>();

    private LocalDateTime deadLine;

    private LocalDateTime createdAt;

    private TaskStatus status;


}
