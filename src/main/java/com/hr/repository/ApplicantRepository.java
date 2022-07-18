package com.hr.repository;

import com.hr.entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

    Applicant findByEmail(String email);
    List<Applicant> findByApplied(Boolean type);
    List<Applicant> findByViewed(Boolean type);
    List<Applicant> findByVacancyID(Long id);
    List<Applicant> findByCreateDateBetween(LocalDateTime start, LocalDateTime end);
}
