package com.task.service.task_service.services;

import com.task.service.task_service.modal.Task;
import com.task.service.task_service.modal.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {


    Task createTask(Task task,String requesterRole) throws  Exception;

    Task getTaskById(Long id) throws  Exception;

    List<Task>getAllTask(TaskStatus status);

    Task updateTask(Long id ,Task updatedTask, Long userId) throws Exception;

    void deleteTask(Long id) throws Exception;

    Task assignedToUser( Long userId,Long taskId) throws  Exception;

    List<Task>assignedUsersTask(Long userId,TaskStatus status);


    Task completeTask(Long taskId) throws Exception;





}
