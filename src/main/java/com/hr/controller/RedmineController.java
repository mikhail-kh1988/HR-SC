package com.hr.controller;

import com.hr.dto.redmine.resplist.IssuesIntegration;
import com.hr.dto.redmine.response.IssueBodyResponse;
import com.hr.service.IRedmineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redmine")
public class RedmineController {

    @Autowired
    private IRedmineService redmineService;


    @GetMapping("/{id}")
    public ResponseEntity<IssueBodyResponse> getIssueById(@PathVariable int id){
        return ResponseEntity.ok(redmineService.getIssueByID(id));
    }

    @GetMapping("/int")
    public ResponseEntity<IssuesIntegration> getIssues(){
        return ResponseEntity.ok(redmineService.getIssueByIntegration());
    }

    @GetMapping("/{id}/update")
    public ResponseEntity<String> updateIssue(@PathVariable int id){
        redmineService.updateIssue(id, null);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(redmineService.getPersonFromRedmine());
    }


}
