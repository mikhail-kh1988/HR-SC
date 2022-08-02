package com.hr.service.impl;

import com.hr.client.RedmineClient;
import com.hr.dto.redmine.request.Issue;
import com.hr.dto.redmine.request.IssueBodyRequest;
import com.hr.entity.Applicant;
import com.hr.service.IRedmineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedmineService implements IRedmineService {


    @Autowired
    private RedmineClient client;

    @Override
    public void createNewIssue(Applicant applicant) {

        IssueBodyRequest issueBody = new IssueBodyRequest();
        Issue issue = new Issue();
        issue.setSubject("Зарегистрирован новый претендент.");

        StringBuilder applicantDescription = new StringBuilder();
        applicantDescription.append(applicant.getFullName());
        applicantDescription.append("\n");
        applicantDescription.append(applicant.getEmail());
        applicantDescription.append("\n");
        applicantDescription.append(applicant.getCvFileName());
        applicantDescription.append("\n");
        applicantDescription.append(applicant.getVacancy().getShortName());
        applicantDescription.append("\n");
        applicantDescription.append(applicant.getDescription());

        issue.setDescription(applicantDescription.toString());
        issue.setProject_id(1);
        issue.setStatus_id(1);
        issue.setCategory_id(5);
        issue.setPriority_id(4);
        issue.setTracker_id(1);

        issueBody.setIssue(issue);

        client.createNewIssue(issueBody);
    }

    @Override
    public void updateIssue(int issueId) {

    }
}
