package com.hr.service;

import com.hr.entity.Person;

import java.util.List;

public interface IPayrollService {

    List<Person> getWorkPersons();

    void setPayroll(List<Person> people);

}
