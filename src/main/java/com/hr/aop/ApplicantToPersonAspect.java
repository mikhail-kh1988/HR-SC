package com.hr.aop;

import com.hr.entity.Applicant;
import com.hr.entity.Person;
import com.hr.entity.PersonHistory;
import com.hr.entity.Vacancy;
import com.hr.repository.PersonHistoryRepository;
import com.hr.repository.PersonRepository;
import com.hr.service.impl.VacancyService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Aspect
@Component
public class ApplicantToPersonAspect {

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private PersonHistoryRepository repository;

    @Autowired
    private PersonRepository personRepository;

    @Pointcut("execution(* com.hr.service.IPersonService.createPersonByApplicant(..))")
    public void callCreatePersonFromApplicant(){}

    @Pointcut("execution(* com.hr.service.IPersonService.setPersonGradeByVacancy(..))")
    public void callChangeJobTitle(){}

    @Pointcut("execution(* com.hr.service.IPersonService.createPersonByPersonDto(..))")
    public void callCreatePersonFromHand(){}

    @After("callCreatePersonFromApplicant()")
    public void afterCallMethod(JoinPoint joinPoint){
        PersonHistory personHistory = new PersonHistory();

        Object[] objects = joinPoint.getArgs();
        Applicant applicant = (Applicant) objects[0];
        Person person = personRepository.findByEmail(applicant.getEmail());

        personHistory.setCreateDate(LocalDateTime.now());
        personHistory.setPerson(person);
        personHistory.setOperation("Претендент "+applicant.getFullName()+" переведен в штат компании. ");

        repository.save(personHistory);

    }

    @After("callChangeJobTitle()")
    public void afterCallChangeJobTitle(JoinPoint joinPoint){
        PersonHistory personHistory = new PersonHistory();
        Object[] jobTitleArgs = joinPoint.getArgs();

        Vacancy vacancy = vacancyService.getVacancyByID((Long) jobTitleArgs[0]);
        Person person = personRepository.findById((Long) jobTitleArgs[1]).get();

        personHistory.setCreateDate(LocalDateTime.now());
        personHistory.setPerson(person);
        personHistory.setOperation("Персоне "+person.getFamilyName()+" присвоена должность "+vacancy.getShortName());

        repository.save(personHistory);
    }


}
