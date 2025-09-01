package com.service.task_submission_service.service;

import com.service.task_submission_service.modal.Submission;
import com.service.task_submission_service.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubimissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;




    @Override
    public Submission submitTask(Long taskId, String githubLink, Long userId) throws Exception {


        return null;
    }

    @Override
    public Submission getTaskSubmissionId(Long submissionId) throws Exception {
        return null;
    }

    @Override
    public List<Submission> getAllTaskSubmissions() {
        return List.of();
    }

    @Override
    public List<Submission> geTaskSubmmisionByTaskId(Long taskId) throws Exception {
        return List.of();
    }

    @Override
    public Submission acceptDeclineSubmission(Long id, String status) throws Exception {
        return null;
    }
}
