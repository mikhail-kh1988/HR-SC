package com.hr.service;

import com.hr.dto.PersonDto;
import com.hr.entity.Applicant;
import com.hr.entity.Person;

import java.util.List;

public interface IPersonService {

    void createPersonByApplicant(Applicant applicant);
    long createPersonByPersonDto(PersonDto dto);
    boolean updatePerson(long personId, PersonDto dto);
    List<Person> getAllPersons();
    List<Person> getPersonByJobTitle(String job);
    List<Person> getPersonBySex(char sex);
    Person getPersonById(long id);
    Person getPersonByEmail(String email);
    void setPersonGradeByVacancy(long vacancyId, long personId);
    void createLoginForPerson(long personId);

}
