package com.hr.controller;

import com.hr.dto.CompanyDto;
import com.hr.dto.ResponseDto;
import com.hr.entity.Company;
import com.hr.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService service;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> createNewCompany(@RequestBody CompanyDto dto){
        return ResponseEntity.ok(new ResponseDto("id:"+service.createCompany(dto)));
    }

    @PostMapping("/{compId}/update")
    public ResponseEntity<ResponseDto> updateCompany(@PathVariable long compId, @RequestBody CompanyDto dto){
        service.updateCompany(compId, dto);
        return ResponseEntity.ok(new ResponseDto("ok"));
    }


}
