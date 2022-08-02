package com.hr.service;

import com.hr.dto.redmine.request.IssueBodyRequest;
import com.hr.entity.Applicant;

public interface IRedmineService {

    void createNewIssue(Applicant applicant);
    void updateIssue(int issueId);
}
