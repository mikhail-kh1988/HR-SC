package com.hr.tool;

import com.hr.dto.redmine.resplist.Issue;



public class Parser {

    public String getContentParameter(Issue i){
        String newNameVacancy = "";
        if (i.getSubject().contains("[ADD] [VACANCY]")) {
            String[] vac = i.getSubject().split(" ");
            newNameVacancy = vac[2];
        }
            return newNameVacancy;
    }

    public String getCommand(Issue issue){
        String[] strings = issue.getSubject().split(" ");
        return strings[0];

    }
}
