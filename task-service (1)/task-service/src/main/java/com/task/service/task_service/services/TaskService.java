package com.task.service.task_service.services;

import com.task.service.task_service.modal.Task;
import com.task.service.task_service.modal.TaskStatus;

import java.util.List;

public interface TaskService {


    Task createTask(Task task,String RequesterRole) throws  Exception;

    Task getTaskById(Long id) throws  Exception;

    List<Task>getAllTask(TaskStatus status);

    Task updateTask(Long id ,Task updatedTask, Long userId) throws Exception;

    void deleteTask(Long id);

    Task assignedToUser( Long id,Long taskId) throws  Exception;

    List<Task>assignedUsersTask(Long userId,TaskStatus status);;


    Task completeTask(Long taskId);




}
