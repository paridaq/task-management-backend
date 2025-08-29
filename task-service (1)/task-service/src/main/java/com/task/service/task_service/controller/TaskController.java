package com.task.service.task_service.controller;

import com.task.service.task_service.modal.Task;
import com.task.service.task_service.modal.UserDto;
import com.task.service.task_service.services.TaskService;
import com.task.service.task_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

     @Autowired
    private UserService userService;
    @PostMapping("")
    public ResponseEntity<Task>createTask(@RequestBody Task task, @RequestHeader("Authorization") String jwt) throws Exception {
        UserDto user = userService.getUserProfile(jwt);
        Task createdTask = taskService.createTask(task,user.getRole());

        return new ResponseEntity<>(createdTask, HttpStatus.CREATED)

    }

}
