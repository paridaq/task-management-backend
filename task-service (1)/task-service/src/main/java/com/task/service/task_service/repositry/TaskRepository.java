package com.task.service.task_service.repositry;

import com.task.service.task_service.modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {


}
