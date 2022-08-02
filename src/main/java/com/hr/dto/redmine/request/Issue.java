package com.hr.dto.redmine.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Issue {
    private int project_id;
    private String subject;
    private int priority_id;
    private int tracker_id;
    private int status_id;
    private String description;
    private int category_id;
    private int estimated_hours;

}
