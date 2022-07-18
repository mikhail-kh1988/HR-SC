package com.hr.controller;

import com.hr.dto.ResponseDto;
import com.hr.dto.VacancyDto;
import com.hr.entity.Vacancy;
import com.hr.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    @Autowired
    private IVacancyService service;

    @PutMapping("/")
    public ResponseEntity<ResponseDto> createNewVacancy(@RequestBody VacancyDto dto){
        return ResponseEntity.ok(new ResponseDto("вакансия зарегистрирована под ID:"+service.addNewVacancy(dto)));
    }

    @GetMapping("/")
    public ResponseEntity<List<Vacancy>> getAllVacancies(){
        return ResponseEntity.ok(service.getAllVacancy());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacancy> getByIdVacancies(@PathVariable long id){
        return ResponseEntity.ok(service.getVacancyByID(id));
    }


}
