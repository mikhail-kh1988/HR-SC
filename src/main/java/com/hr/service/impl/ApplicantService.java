package com.hr.service.impl;

import com.hr.dto.ApplicantDto;
import com.hr.dto.ResponseDto;
import com.hr.entity.Applicant;
import com.hr.repository.ApplicantRepository;
import com.hr.service.IApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApplicantService implements IApplicantService {

    @Autowired
    private ApplicantRepository repository;

    @Autowired
    private VacancyService vacancyService;

    @Override
    public ResponseDto registration(ApplicantDto dto) {
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

        return new ResponseDto("Регистрация прошла успешно.");
    }
}
