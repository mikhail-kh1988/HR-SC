package com.hr.repository;

import com.hr.entity.Payroll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends CrudRepository<Payroll, Long> {
}
