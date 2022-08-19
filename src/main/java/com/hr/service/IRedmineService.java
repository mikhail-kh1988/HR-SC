package com.hr.service;


import com.hr.dto.redmine.response.IssueBodyResponse;
import com.hr.dto.redmine.resplist.IssuesIntegration;
import com.hr.entity.Applicant;
import com.hr.entity.Person;
import com.hr.entity.TaskIssue;
import java.util.List;

public interface IRedmineService {

    void createNewIssue(Applicant applicant);
    void updateIssue(int issueId, TaskIssue issue);

    IssueBodyResponse getIssueByID(int id);
    IssuesIntegration getIssueByIntegration();

    void createNewUser(Person person);

    List<Person> getPersonFromRedmine();
}
