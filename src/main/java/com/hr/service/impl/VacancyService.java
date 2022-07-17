package com.hr.service.impl;

import com.hr.dto.VacancyDto;
import com.hr.entity.Vacancy;
import com.hr.repository.VacancyRepository;
import com.hr.service.IVacancyService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacancyService implements IVacancyService {

    @Autowired
    private VacancyRepository repository;

    @Override
    public long addNewVacancy(VacancyDto dto) {
        Vacancy vacancy = new Vacancy();

        vacancy.setShortName(dto.getShortName());
        vacancy.setDescription(dto.getDescription());

        return repository.save(vacancy).getID();

    }

    @Override
    public List<Vacancy> getAllVacancy() {
        List<Vacancy> list = new ArrayList<>();

        for ( Vacancy v: repository.findAll()) {
            list.add(v);
        }

        return list;
    }

    @Override
    public Vacancy getVacancyByID(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Vacancy getVacancyByName(String name) {
        return repository.findByShortName(name);
    }

}
