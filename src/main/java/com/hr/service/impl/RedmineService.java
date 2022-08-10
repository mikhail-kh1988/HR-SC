package com.hr.service.impl;

import com.hr.client.RedmineAdminClient;
import com.hr.client.RedmineClient;
import com.hr.dto.redmine.request.Issue;
import com.hr.dto.redmine.request.IssueBodyRequest;
import com.hr.dto.redmine.user.RequestCreateUserDto;
import com.hr.dto.redmine.resplist.IssuesIntegration;
import com.hr.dto.redmine.response.IssueBodyResponse;
import com.hr.entity.Applicant;
import com.hr.entity.Person;
import com.hr.entity.TaskIssue;
import com.hr.service.IRedmineService;
import com.hr.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedmineService implements IRedmineService {

    @Autowired
    private RedmineClient client;

    @Autowired
    private RedmineAdminClient adminClient;

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
    public void updateIssue(int issueId, TaskIssue issues) {

        IssueBodyResponse issueResponse = client.getIssueByID(issueId);

        IssueBodyRequest request = new IssueBodyRequest();
        Issue issue = new Issue();
        issue.setStatus_id(3);
        issue.setPriority_id(issueResponse.getIssue().getPriority().getId());
        issue.setCategory_id(5);
        issue.setSubject(issueResponse.getIssue().getSubject());
        issue.setDescription(issueResponse.getIssue().getDescription());

        request.setIssue(issue);
        try {
            client.updateIssue(issueId, request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public IssueBodyResponse getIssueByID(int id) {
        return client.getIssueByID(id);
    }

    @Override
    public IssuesIntegration getIssueByIntegration() {

        IssuesIntegration list = null;

        try {

            list = client.getIssuesByStatus();
        } catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void createNewUser(Person person) {

        RequestCreateUserDto dto = new RequestCreateUserDto();
        com.hr.dto.redmine.user.User user = new com.hr.dto.redmine.user.User();

        user.setFirstname(person.getFirstName());
        user.setLastname(person.getFamilyName());
        user.setLogin(person.getUser().getLogin());
        user.setMail(person.getEmail());
        user.setPassword("123456789");
        user.setGenerate_password(false);
        user.setMust_change_passwd(true);
        user.setAuth_source_id(0);
        user.setMail_notification("only_my_events");

        dto.setUser(user);

        adminClient.createNewUser(dto);
    }
}
