package com.service.task_submission_service.controller;


import com.service.task_submission_service.modal.Submission;
import com.service.task_submission_service.modal.UserDto;
import com.service.task_submission_service.service.SubmissionService;
import com.service.task_submission_service.service.TaskService;
import com.service.task_submission_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {


   @Autowired
   private SubmissionService submissionService;

   @Autowired
   private UserService userService;

   @Autowired
    private TaskService taskService;


   @PostMapping()
    public ResponseEntity<Submission> submitTask(@RequestParam Long task_id
   , @RequestParam String github_link, @RequestHeader("Authorization") String jwt) throws Exception{

       UserDto user = userService.getUserProfile(jwt);
       Submission submission = submissionService.submitTask(task_id,github_link,user.getId(),jwt);
       return new ResponseEntity<>(submission, HttpStatus.CREATED);
   }

   //we use pathvariable anotation to extraract value from the url
    //we use requestparam to extract query parameter

   @GetMapping("{id}")
    public ResponseEntity<Submission>getSubmissionId(@PathVariable Long id,@RequestHeader ("Authorization") String jwt) throws Exception{

       UserDto user = userService.getUserProfile(jwt);
       Submission submission= submissionService.getTaskSubmissionId(id);
       return new ResponseEntity<>(submission,HttpStatus.OK);
   }

    @GetMapping()
    public ResponseEntity<List<Submission>>getSubmissions(@RequestHeader ("Authorization") String jwt) throws Exception{

       UserDto user = userService.getUserProfile(jwt);
       List<Submission> submissions = submissionService.getAllTaskSubmissions();
       return new ResponseEntity<>(submissions,HttpStatus.OK);
    }


    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Submission>> getAllTaskSubmissions(@PathVariable Long taskId,@RequestHeader("Authorization") String jwt) throws  Exception{
       UserDto user = userService.getUserProfile(jwt);
       List<Submission> submissions = submissionService.geTaskSubmmisionByTaskId(taskId);
       return new ResponseEntity<>(submissions,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Submission> acceptOrDeclineSubmissions(@PathVariable Long id,@RequestHeader("Authorization") String jwt,@RequestParam ("status") String status) throws  Exception{
     UserDto user = userService.getUserProfile(jwt);
     Submission submission = submissionService.acceptDeclineSubmission(id,status);
     return new ResponseEntity<>(submission,HttpStatus.OK);
    }






}
