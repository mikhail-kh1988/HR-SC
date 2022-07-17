package com.hr.service;

import com.hr.dto.VacancyDto;
import com.hr.entity.Vacancy;

import java.util.List;

public interface IVacancyService {

    long addNewVacancy(VacancyDto dto);
    List<Vacancy> getAllVacancy();
    Vacancy getVacancyByID(long id);
    Vacancy getVacancyByName(String name);
}
