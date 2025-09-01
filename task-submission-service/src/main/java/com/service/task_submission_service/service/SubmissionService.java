package com.service.task_submission_service.service;

import com.service.task_submission_service.modal.Submission;

import java.util.List;

public interface SubmissionService {

    Submission submitTask(Long taskId,String githubLink,Long userId) throws Exception;

    Submission getTaskSubmissionId(Long submissionId) throws Exception;

    List<Submission>getAllTaskSubmissions();

    List<Submission> geTaskSubmmisionByTaskId(Long taskId) throws Exception;

    Submission acceptDeclineSubmission(Long id,String status) throws Exception;




}
