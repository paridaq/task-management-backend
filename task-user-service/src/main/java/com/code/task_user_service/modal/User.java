package com.code.task_user_service.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;







@Entity
@NoArgsConstructor
//generate default constructor automatically
@AllArgsConstructor
//generate all the constructor with all the field as parameteres
@Data
//it is for autogeneration of the getters and setters
@Table
// table anotaion is used along with entity and specifies the table name in the DB
//if not provided hibernate will use the class name as the table name by default


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String password;
    private String email;
    private String role;
    private String fullName;


}
