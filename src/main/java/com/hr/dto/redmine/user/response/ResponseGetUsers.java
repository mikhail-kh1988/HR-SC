package com.hr.dto.redmine.user.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ResponseGetUsers {

    private ArrayList<User> users;
    private int total_count;
    private int offset;
    private int limit;

}
