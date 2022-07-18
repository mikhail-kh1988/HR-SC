package com.hr.service;

import com.hr.dto.ApplicantDto;
import com.hr.dto.ResponseDto;
import com.hr.entity.Applicant;

import java.util.List;

public interface IApplicantService {

    void registration(ApplicantDto dto);
    List<Applicant> getAllApplicants();
    List<Applicant> getNotViewedApplicant();
    List<Applicant> getApplicantByVacancyId(long vacancyId);
    void applicantIsViewed(long applicantId);
    Applicant getApplicantById(long id);
    void applyApplicant(long id);
    ResponseDto getStatusApplicant(long id);
}
