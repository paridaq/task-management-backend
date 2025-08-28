package com.task.service.task_service.services;

import com.task.service.task_service.modal.Task;
import com.task.service.task_service.modal.TaskStatus;
import com.task.service.task_service.repositry.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class TaskServiceImplementation implements TaskService{
    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task createTask(Task task, String requesterRole) throws Exception {
        if(!requesterRole.equals(("ROLE_ADMIN"))){
            throw new Exception("only admin can create task");
        }
        task.setStatus(TaskStatus.PENDING);
        task.setCreatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) throws Exception {
        return taskRepository.findById(id).orElseThrow(()->new Exception("Task not found with id "+id));
    }

    @Override
    public List<Task> getAllTask(TaskStatus status) {
        return List.of();
    }

    @Override
    public Task updateTask(Long id, Task updatedTask, Long userId) throws Exception {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public Task assignedToUser(Long id, Long taskId) throws Exception {
        return null;
    }

    @Override
    public List<Task> assignedUsersTask(Long userId, TaskStatus status) {
        return List.of();
    }

    @Override
    public Task completeTask(Long taskId) throws Exception {
        return null;
    }
}
