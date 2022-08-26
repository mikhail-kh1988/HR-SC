package com.hr.repository;

import com.hr.entity.Payroll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PayrollRepository extends CrudRepository<Payroll, Long> {

    List<Payroll> findByCreateDateBetween(LocalDateTime start, LocalDateTime end);
    List<Payroll> findByDocumentExternalId(String externalID);
}
