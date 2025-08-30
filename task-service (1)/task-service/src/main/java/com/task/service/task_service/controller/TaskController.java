package com.task.service.task_service.controller;

import com.task.service.task_service.modal.Task;
import com.task.service.task_service.modal.TaskStatus;
import com.task.service.task_service.modal.UserDto;
import com.task.service.task_service.services.TaskService;
import com.task.service.task_service.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<Task>getTaskById(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception{
        UserDto user = userService.getUserProfile(jwt);
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task,HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<List<Task>> getAssignedUserTask(
            @RequestParam(required = false)TaskStatus status,
            @RequestHeader("Authorization") String jwt) throws Exception{
        UserDto user = userService.getUserProfile(jwt);
        List<Task> tasks = taskService.assignedUsersTask(user.getId(),status);
        return new ResponseEntity<>(tasks,HttpStatus.CREATED);
    }

}
