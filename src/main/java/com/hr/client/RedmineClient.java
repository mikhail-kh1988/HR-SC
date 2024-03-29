package com.hr.client;

import com.hr.dto.redmine.request.IssueBodyRequest;
import com.hr.dto.redmine.resplist.IssuesIntegration;
import com.hr.dto.redmine.response.IssueBodyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "redmineClient", url = "http://localhost:3000", configuration = FeignClientRedmineConfig.class)
public interface RedmineClient {

    @PostMapping("/issues.json")
    IssueBodyResponse createNewIssue(@RequestBody IssueBodyRequest request);
    @GetMapping("/issues/{id}.json")
    IssueBodyResponse getIssueByID(@PathVariable int id);

    @GetMapping("/issues.json?status_id=5&project_id=1")
    IssuesIntegration getIssuesByStatus();

    @PutMapping("/issues/{id}.json")
    void updateIssue(@PathVariable int id, @RequestBody IssueBodyRequest request);



}
