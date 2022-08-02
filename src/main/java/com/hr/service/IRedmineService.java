package com.hr.service;


import com.hr.dto.redmine.response.IssueBodyResponse;
import com.hr.dto.redmine.resplist.Root;
import com.hr.entity.Applicant;
import com.hr.entity.Person;

import java.util.List;

public interface IRedmineService {

    void createNewIssue(Applicant applicant);
    void updateIssue(int issueId);

    IssueBodyResponse getIssueByID(int id);
    List<Root> getIssueByIntegration();

    void createNewUser(Person person);
}
