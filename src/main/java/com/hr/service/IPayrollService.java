package com.hr.service;

import com.hr.entity.Payroll;
import com.hr.entity.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IPayrollService {
    List<Person> getWorkPersons();
    List<Payroll> setPayroll(List<Person> people);
    BigDecimal getPrepBudget(List<Person> people);
    boolean sendIntoBank(List<Payroll> payrollList);
    List<Payroll> getCurrentPayrollList();
    List<Payroll> createPayrollBy(List<Person> people, String documentID, LocalDate startPeriod, LocalDate endPeriod);

}
