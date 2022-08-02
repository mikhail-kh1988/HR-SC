package com.hr.client;

import com.hr.dto.redmine.request.IssueBodyRequest;
import com.hr.dto.redmine.response.IssueBodyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "redmineClient", url = "http://localhost:3000", configuration = FeignClientRedmineConfig.class)
public interface RedmineClient {

    @PostMapping("/issues.json")
    IssueBodyResponse createNewIssue(@RequestBody IssueBodyRequest request);

}
