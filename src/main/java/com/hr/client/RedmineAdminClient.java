package com.hr.client;

import com.hr.dto.redmine.user.RequestCreateUserDto;
import com.hr.dto.redmine.user.response.ResponseCreateUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "redmineClientAdmin", url = "http://localhost:3000", configuration = FeignClintRedmineAdminConfig.class)
public interface RedmineAdminClient {

    @PostMapping("/users.json")
    ResponseCreateUserDto createNewUser(@RequestBody RequestCreateUserDto dto);
}
