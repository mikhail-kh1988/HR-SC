package com.hr.dto.redmine.resplist;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Issue {
    private int id;
    private Project project;
    private Tracker tracker;
    private Status status;
    private Priority priority;
    private Author author;
    private Category category;
    private String subject;
    private String description;
    private LocalDate start_date;
    private LocalDate due_date;
    private int done_ratio;
    private boolean is_private;
    private Object estimated_hours;
    private Object total_estimated_hours;
    private LocalDate created_on;
    private LocalDate updated_on;
    private Object closed_on;
}
