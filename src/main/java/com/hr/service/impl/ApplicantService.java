package com.hr.service.impl;

import com.hr.dto.ApplicantDto;
import com.hr.dto.ResponseDto;
import com.hr.entity.Applicant;
import com.hr.repository.ApplicantRepository;
import com.hr.service.IApplicantService;
import com.hr.service.IPersonService;
import com.hr.service.IRedmineService;
import com.hr.service.IVacancyService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
public class ApplicantService implements IApplicantService {

    @Autowired
    private ApplicantRepository repository;

    @Autowired
    private IVacancyService vacancyService;

    @Autowired
    private IPersonService personService;

    @Autowired
    private IRedmineService redmineService;

    @Override
    public void registration(ApplicantDto dto) {
        Applicant applicant = new Applicant();

        applicant.setFullName(dto.getFullName());
        applicant.setEmail(dto.getEmail());
        applicant.setDescription(dto.getDescription());
        applicant.setCvFileName(dto.getCvFileName());
        applicant.setCreateDate(LocalDateTime.now());
        applicant.setVacancy(vacancyService.getVacancyByID(dto.getVacancyId()));
        applicant.setViewed(false);
        applicant.setApplied(false);

        repository.save(applicant);
        redmineService.createNewIssue(applicant);

    }

    @Override
    public List<Applicant> getAllApplicants() {
        List<Applicant> applicants = new ArrayList<>();

        for (Applicant a: repository.findAll()) {
            applicants.add(a);
        }

        return applicants;
    }

    @Override
    public List<Applicant> getNotViewedApplicant() {
        return repository.findByViewed(false);
    }

    @Override
    public List<Applicant> getApplicantByVacancyId(long vacancyId) {
        return repository.findByVacancyID(vacancyId);
    }

    @Override
    public void applicantIsViewed(long applicantId) {
        Applicant applicant = repository.findById(applicantId).get();

        applicant.setViewed(true);

        repository.save(applicant);
    }

    @Override
    public Applicant getApplicantById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void applyApplicant(long id) {
        Applicant applicant = repository.findById(id).get();

        applicant.setApplied(true);

        repository.save(applicant);

        personService.createPersonByApplicant(applicant);
    }

    @Override
    public ResponseDto getStatusApplicant(long id) {
        Applicant applicant = repository.findById(id).get();

        if (applicant.getApplied()){
            return new ResponseDto("Поздравляем вы приняты! За дополнительной информацией обращайтесь в HR");
        } else if(applicant.getViewed()){
            return new ResponseDto("Ваше резюме просмотрено.");
        }
        return new ResponseDto("Ваше резюме пока не просмотрено.");
    }
}
