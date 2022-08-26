package com.hr.service.impl;

import com.hr.entity.Payroll;
import com.hr.entity.Person;
import com.hr.entity.PersonDocument;
import com.hr.repository.PayrollRepository;
import com.hr.service.IPayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class PayrollService implements IPayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private PersonService personService;

    @Override
    public List<Person> getWorkPersons() {
        List<Person> people = new ArrayList<>();

        for (Person person: personService.getAllPersons()) {
            if (person.getStatus() > 1000){
                people.add(person);
            }
        }

        return people;
    }

    @Override
    public List<Payroll> setPayroll(List<Person> people) {
        return null;
    }

    @Override
    public BigDecimal getPrepBudget(List<Person> people) {

        BigDecimal tempSum = new BigDecimal(0);

        for (Person person:people) {
            if (person.getDocument() != null) {
                PersonDocument document = person.getDocument();
                tempSum = tempSum.add(document.getSalary());
            }
        }

        return tempSum;
    }

    @Override
    public boolean sendIntoBank(List<Payroll> payrollList) {
        return false;
    }

    @Override
    public List<Payroll> getCurrentPayrollList() {
        return null;
    }

    @Override
    public List<Payroll> createPayrollBy(List<Person> people, String documentID, LocalDate startPeriod, LocalDate endPeriod) {
        return null;
    }
}
