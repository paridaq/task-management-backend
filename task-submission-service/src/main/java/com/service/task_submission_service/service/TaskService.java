package com.service.task_submission_service.service;


import com.service.task_submission_service.modal.TaskDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "SUBMISSION-SERVICE",url ="http://loclhost:5002" )
public interface TaskService {

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception;


    @PutMapping("/{id}/complete")
    public ResponseEntity<TaskDto> completeTask(@PathVariable Long id) throws Exception;
}
