package com.task.service.task_service.services;

import com.task.service.task_service.modal.Task;

import java.util.List;

public interface TaskService {


    Task createTask(Task task,String RequesterRole) throws  Exception;

    Task getTaskById(Long id) throws  Exception;

    List


}
