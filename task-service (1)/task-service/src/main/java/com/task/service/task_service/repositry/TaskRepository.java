package com.task.service.task_service.repositry;

import com.task.service.task_service.modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

public List<Task>findByAssignedUserId(Long userId);
//spring jpa automatically generate the the query by looking the name format like it look for assineduserid in the entity and perform like findbyid;
}
