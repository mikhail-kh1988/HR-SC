package com.hr.service;

import com.hr.entity.TaskIssue;

import java.util.List;

public interface IIssueTaskService {

    List<TaskIssue> getListIntegrationIssues();
    void workAroundForApplicant(String email);
}
