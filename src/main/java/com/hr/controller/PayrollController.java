package com.hr.controller;

import com.hr.service.IPayrollService;
import com.hr.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private IPayrollService service;

    @Autowired
    private IPersonService personService;


    @GetMapping("/budget")
    public ResponseEntity<BigDecimal> getPreBudget(){
        return ResponseEntity.ok(service.getPrepBudget(personService.getAllPersons()));
    }

}
