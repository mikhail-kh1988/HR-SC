package com.hr.dto.redmine.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Getter
@Setter
public class Issues {
    private int id;
    private Project project;
    private Tracker tracker;
    private Status status;
    private Priority priority;
    private Author author;
    private Category category;
    private String subject;
    private String description;
    private String start_date;
    private Object due_date;
    private int done_ratio;
    private boolean is_private;
    private Object estimated_hours;
    private Object total_estimated_hours;
    private Date created_on;
    private Date updated_on;
    private Object closed_on;
}
