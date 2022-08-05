package com.hr.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskIssue {

    private int redmineId;
    private String subject;
    private String description;
    private int status;

}
