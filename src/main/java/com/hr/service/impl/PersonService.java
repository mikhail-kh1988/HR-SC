package com.hr.service.impl;

import com.hr.dto.AllDocumentDto;
import com.hr.dto.PersonDto;
import com.hr.entity.*;
import com.hr.repository.PersonRepository;
import com.hr.service.IPersonService;
import com.hr.service.IUserService;
import com.hr.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private IVacancyService vacancyService;

    @Autowired
    private IUserService userService;

    /*@Autowired
    private IRedmineService redmineService;*/

    @Override
    public void createPersonByApplicant(Applicant applicant) {
        Person person = new Person();
        PersonDocument document = new PersonDocument();

        String[] names = applicant.getFullName().split(" ");

        person.setFamilyName(names[0]);
        person.setFirstName(names[1]);
        person.setLastName(names[2]);

        person.setEmail(applicant.getEmail());
        person.setDescription(applicant.getDescription());
        person.setGrade(applicant.getVacancy().getGrade());
        person.setJobTitle(applicant.getVacancy().getShortName());

        person.setCreateDate(LocalDateTime.now());
        person.setSex('N');
        person.setStatus(1000);

        document.setCurrentGrade(person.getGrade());
        person.setDocument(document);

        repository.save(person);
    }

    @Override
    public long createPersonByPersonDto(PersonDto dto) {

        Person person = new Person();
        PersonDocument document = new PersonDocument();

        person.setFamilyName(dto.getFamily());
        person.setFirstName(dto.getName());
        person.setLastName(dto.getFatherName());
        person.setBirthday(dto.getBirthday());
        person.setSex(dto.getSex());
        person.setJobTitle(dto.getJobTitle());
        person.setCreateDate(LocalDateTime.now());
        person.setStatus(1000);
        person.setGrade(1);
        person.setEmail(dto.getEmail());

        document.setCurrentGrade(person.getGrade());
        person.setDocument(document);

        return repository.save(person).getID();
    }

    @Override
    public boolean updatePerson(long personId, PersonDto dto) {
        Person person = repository.findById(personId).get();

        person.setFamilyName(dto.getFamily());
        person.setFirstName(dto.getName());
        person.setLastName(dto.getFatherName());
        person.setBirthday(dto.getBirthday());
        person.setSex(dto.getSex());
        person.setJobTitle(dto.getJobTitle());

        if (repository.save(person).getID() == null )
            return false;

        return true;
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<>();

        for (Person p: repository.findAll()) {
            personList.add(p);
        }

        return personList;
    }

    @Override
    public List<Person> getPersonByJobTitle(String job) {
        return repository.findByJobTitle(job);
    }

    @Override
    public List<Person> getPersonBySex(char sex) {
        return repository.findBySex(sex);
    }

    @Override
    public Person getPersonById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Person getPersonByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void setPersonGradeByVacancy(long vacancyId, long personId) {
        Vacancy vacancy = vacancyService.getVacancyByID(vacancyId);

        Person person = repository.findById(personId).get();

        person.setGrade(vacancy.getGrade());
        person.setJobTitle(vacancy.getShortName());

        repository.save(person);
    }

    @Override
    public void addDocumentForPerson(Long personId, AllDocumentDto dto) {
        Person person = repository.findById(personId).get();
        char sex = dto.getSex().toUpperCase().charAt(0);
        PersonDocument document = person.getDocument();
        Passport passport = new Passport();
        SNILS snils = new SNILS();

        passport.setFio(dto.getFio());
        passport.setSex(sex);
        passport.setBirthDay(dto.getBirthDay());

        snils.setFio(dto.getFio());
        snils.setBirthDay(dto.getBirthDay());
        snils.setSex(dto.getSex());

        document.setPassport(passport);
        document.setSnils(snils);

        person.setDocument(document);
        repository.save(person);

    }

    /*@Override
    public void createLoginForPerson(long personId) {

        Person person = repository.findById(personId).get();

        userService.createUserFromPerson(person);

        try {

            redmineService.createNewUser(person);
        }catch (Exception e){
            e.printStackTrace();
        }

    }*/

}
