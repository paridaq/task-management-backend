package com.service.task_submission_service.service;

import com.service.task_submission_service.modal.Submission;
import com.service.task_submission_service.modal.TaskDto;
import com.service.task_submission_service.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class SubimissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private TaskService taskService;




    @Override
    public Submission submitTask(Long taskId, String githubLink, Long userId,String jwt) throws Exception {
        TaskDto task = taskService.getTaskById(taskId,jwt);
        if(task!=null){
            Submission submission= new Submission();
            submission.setTaskId(taskId);
            submission.setUserId(userId);
            submission.setGithubLink(githubLink);
            submission.setSubmissionTime(LocalDateTime.now());
          return submissionRepository.save(submission);
        }
        throw new Exception("Task not found with taskid"+taskId);



    }

    @Override
    public Submission getTaskSubmissionId(Long submissionId) throws Exception {
        return submissionRepository.findById(submissionId).orElseThrow(()->new  Exception("task submission not found with id"+submissionId));
    }

    @Override
    public List<Submission> getAllTaskSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public List<Submission> geTaskSubmmisionByTaskId(Long taskId) throws Exception {
        return submissionRepository.findByTaskId(taskId);
    }

    @Override
    public Submission acceptDeclineSubmission(Long id, String status) throws Exception {
        Submission submission = getTaskSubmissionId(id);
        submission.setStatus(status);
        taskService.completeTask(submission.getTaskId());
        return submissionRepository.save(submission);
    }
}
