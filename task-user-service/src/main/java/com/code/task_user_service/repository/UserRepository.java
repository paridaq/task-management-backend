package com.code.task_user_service.repository;

import com.code.task_user_service.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {

public User findByEmail(String email);

}
