package com.hr.dto.redmine.resplist;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class IssuesIntegration {
    private ArrayList<Issue> issues;
    private int total_count;
    private int offset;
    private int limit;
}
