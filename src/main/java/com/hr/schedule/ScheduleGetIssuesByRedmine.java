package com.hr.schedule;

import com.hr.dto.VacancyDto;
import com.hr.dto.redmine.resplist.Issue;
import com.hr.dto.redmine.resplist.IssuesIntegration;
import com.hr.service.IRedmineService;
import com.hr.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleGetIssuesByRedmine {

    @Autowired
    private IVacancyService vacancyService;
    
    @Autowired
    private IRedmineService redmineService;

    @Scheduled(fixedDelay = 5000)
    public void scheduledTask(){
        IssuesIntegration issueByIntegration = redmineService.getIssueByIntegration();

        for (Issue i: issueByIntegration.getIssues()) {
            if (i.getSubject().contains("[ADD] [VACANCY]")){
                String[] vac = i.getSubject().split(" ");
                String newNameVacancy = vac[2];
                vacancyService.addNewVacancy(parseDescription(newNameVacancy, i.getDescription()));
                redmineService.updateIssue(i.getId(), null);
            }
        }
    }

    private VacancyDto parseDescription(String shortName, String description){
        VacancyDto dto = new VacancyDto();
        dto.setShortName(shortName);

        String[] str = description.split("\n");

        for (String s: str) {
            if (s.contains("[GRD]")){
                dto.setGrade(Integer.parseInt(s.substring(5, 6)));
            }
        }
        dto.setDescription(description);
        return dto;
    }

}
